package com.example.android.movie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

//@GET("/JSONParsingTutorial/jsonMovie")
//Call<MovieService> getMovies();

    //merubah kode menjadi seperi berikut
    @GET("/")
    Call<com.example.android.movie.MovieResponse> getMovies();
}