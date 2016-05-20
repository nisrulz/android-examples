package sample.github.nisrulz.usingretrofit2.rest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sample.github.nisrulz.usingretrofit2.BuildConfig;

public class RetrofitHelper {

  public static final String BASE_URL = "http://swapi.co/api/";

  private final Retrofit retrofit;
  private final APIServiceInterface APIServiceInterface;

  // Use a connection pool , here 5 request are possible and they will be discarded after 60 seconds
  ConnectionPool connectionPool = new ConnectionPool(5, 60, TimeUnit.SECONDS);

  public RetrofitHelper() {
    retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
        .client(getClientWithConfigs(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
            : HttpLoggingInterceptor.Level.NONE))
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    APIServiceInterface = retrofit.create(APIServiceInterface.class);
  }

  public Retrofit getClient() {
    return retrofit;
  }

  public APIServiceInterface getAPIServiceInterface() {
    return APIServiceInterface;
  }

  private OkHttpClient getClientWithConfigs(HttpLoggingInterceptor.Level level) {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(level);

    Interceptor headeInterceptor = new Interceptor() {
      @Override public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
            .header("key1", "value1")
            .header("Content-Type", "application/json")
            .method(original.method(), original.body())
            .build();

        return chain.proceed(request);
      }
    };

    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        .addInterceptor(headeInterceptor)
        .connectionPool(connectionPool)
        .retryOnConnectionFailure(true)
        .build();

    return okHttpClient;
  }
}
