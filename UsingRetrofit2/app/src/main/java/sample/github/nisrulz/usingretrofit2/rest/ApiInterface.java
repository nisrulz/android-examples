package sample.github.nisrulz.usingretrofit2.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import sample.github.nisrulz.usingretrofit2.model.PeopleResponse;

public interface ApiInterface {
  @GET("people")
  Call<PeopleResponse> getPeople();
}
