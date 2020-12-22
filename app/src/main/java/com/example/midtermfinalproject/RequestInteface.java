package com.example.midtermfinalproject;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface RequestInteface {
    @GET("repositories")
    Call<List<Owner>> getCarsJson();
}
