package com.adammcneilly.retrofitsample;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Service interface for connecting with our backend.
 *
 * Created by adam.mcneilly on 8/22/16.
 */
public interface PersonService {

    @GET("people/presidents")
    Call<Presidents> getPresidents();

    @GET("people/{id}")
    Call<Person> getPerson(@Path("id") String id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/androidessence/RetrofitSample/master/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
