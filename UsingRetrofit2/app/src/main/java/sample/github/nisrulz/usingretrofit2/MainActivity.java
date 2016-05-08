package sample.github.nisrulz.usingretrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sample.github.nisrulz.usingretrofit2.model.People;
import sample.github.nisrulz.usingretrofit2.model.PeopleResponse;
import sample.github.nisrulz.usingretrofit2.rest.ApiClient;
import sample.github.nisrulz.usingretrofit2.rest.ApiInterface;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    Call<PeopleResponse> call = apiService.getPeople();
    call.enqueue(new Callback<PeopleResponse>() {
      @Override
      public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
        List<People> peoples = response.body().getPeoples();
        System.out.println("Count of Peoples : " + peoples.size());
        for (People people : peoples) {
          System.out.println(people.getName());
        }
      }

      @Override public void onFailure(Call<PeopleResponse> call, Throwable t) {
        // Log error here since request failed
        Log.e(TAG, t.toString());
      }
    });
  }
}
