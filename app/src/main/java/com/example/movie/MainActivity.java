package com.example.android.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_movies)
    RecyclerView listMovies;
    com.example.android.movie.MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new com.example.android.movie.MovieAdapter();
        listMovies.setLayoutManager(new LinearLayoutManager(this));
        listMovies.setAdapter(adapter);
        listMovies.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        com.example.android.movie.RestClient.getMovieService().getMovies().enqueue(new Callback<com.example.android.movie.MovieResponse>() {
            // error Callback<MovieResponse>()

            @Override
            public void onResponse(Call<com.example.android.movie.MovieResponse> call, Response<com.example.android.movie.MovieResponse> response) {
                adapter.listMovies.addAll(response.body().getSearch());
                // error adapter.listMovies.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<com.example.android.movie.MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}

