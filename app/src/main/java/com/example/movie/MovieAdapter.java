package com.example.android.movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;





public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public ArrayList<com.example.android.movie.SearchItem> listMovies = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        // Flow update view/UI dari viewholdernya
        holder.bind(listMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // ButterKnife diganti dengan ViewBinding
        @BindView(R.id.civPoster)
        CircleImageView civPoster;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvReleaseYear)
        TextView tvReleased;
        @BindView(R.id.tvType)
        TextView tvType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(com.example.android.movie.SearchItem data) {
            tvTitle.setText(data.getTitle());
            tvType.setText(data.getType());
            tvReleased.setText(data.getYear());
            Glide.with(civPoster)
                    .load(data.getPoster())
                    .into(civPoster);
        }
    }
}
