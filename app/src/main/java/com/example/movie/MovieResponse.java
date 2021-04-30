package com.example.android.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Nama Field harus sama persis dengan response.
// alternatif pakai menambahkan @SerializedName("nama_field_response")
public class MovieResponse{
	@SerializedName("Response")
	private String response;
	@SerializedName("totalResults")
	private String totalResults;
	@SerializedName("Search")
	private List<com.example.android.movie.SearchItem> search;


	public String getResponse(){
		return response;
	}

	public void setTotalResults(String totalResults){
		this.totalResults = totalResults;
	}

	public String getTotalResults(){
		return totalResults;
	}

	public void setSearch(List<com.example.android.movie.SearchItem> search){
		this.search = search;
	}

	public List<com.example.android.movie.SearchItem> getSearch(){
		return search;
	}
}
