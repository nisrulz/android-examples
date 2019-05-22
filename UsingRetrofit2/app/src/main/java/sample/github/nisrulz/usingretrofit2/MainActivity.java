package sample.github.nisrulz.usingretrofit2;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sample.github.nisrulz.usingretrofit2.list.ListAdapter;
import sample.github.nisrulz.usingretrofit2.model.People;
import sample.github.nisrulz.usingretrofit2.model.PeopleResponse;
import sample.github.nisrulz.usingretrofit2.rest.APIError;
import sample.github.nisrulz.usingretrofit2.rest.APIServiceInterface;
import sample.github.nisrulz.usingretrofit2.rest.NetworkErrorUtils;
import sample.github.nisrulz.usingretrofit2.rest.RetrofitHelper;

public class MainActivity extends AppCompatActivity {

  private static final String LOGTAG = MainActivity.class.getSimpleName();

  private ProgressDialog progressDialog;

  private RetrofitHelper retrofitHelper;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    progressDialog = new ProgressDialog(this);
    progressDialog.setMessage("Loading..");
    progressDialog.setIndeterminate(true);
    progressDialog.setCanceledOnTouchOutside(false);
    progressDialog.show();

    final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_peoples);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    retrofitHelper = new RetrofitHelper();

    APIServiceInterface apiService = retrofitHelper.getAPIServiceInterface();

    Call<PeopleResponse> call = apiService.getPeople();
    call.enqueue(new Callback<PeopleResponse>() {
      @Override
      public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
        if (response.isSuccessful()) {
          List<People> peoples = response.body().getPeoples();
          recyclerView.setAdapter(new ListAdapter(peoples, R.layout.list_item_people));
        } else {
          // parse the response body …
          APIError error = NetworkErrorUtils.parseError(retrofitHelper, response);
          // … and use it to show error information

          // … or just log the issue like we’re doing :)
          Log.d(LOGTAG, "error status : "
              + response.code()
              + " | error message : "
              + error.message()
              + " | error code : "
              + error.code());
        }
        progressDialog.dismiss();
      }

      @Override public void onFailure(Call<PeopleResponse> call, Throwable t) {
        // Log error here since request failed
        t.printStackTrace();
        Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
        progressDialog.dismiss();
      }
    });
  }
}
