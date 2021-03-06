package dk.dkln.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import dk.dkln.R;
import dk.dkln.bean.movie.MovieListResponse;
import dk.dkln.mvp.view.movie.MovieCeshiActivity;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieListProvider extends
        ItemViewProvider<MovieListResponse ,MovieListProvider.MovieListHolder> {

    @NonNull
    @Override
    protected MovieListHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_list , parent ,false);
        return new MovieListHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final MovieListHolder holder, @NonNull final MovieListResponse movieList) {
        Glide.with(holder.itemView.getContext())
                .load(movieList.getImages().getLarge())
                .into(holder.iv_book_img);
        holder.tv_book_title.setText(movieList.getTitle());
        holder.ratingBar_hots.setRating(Float.valueOf(movieList.getRating().getAverage()) / 2);
        holder.tv_hots_num.setText(movieList.getRating().getAverage());
        holder.tv_book_info.setText(movieList.getOriginal_title());
        holder.tv_book_description.setText("\u3000" + movieList.getYear());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String url = (String)URL.URL_MOVIE + movieList.getId() + "/";
//                Intent intent = WebActivity.newIntent(holder.itemView.getContext()
//                 , url , movieList.getTitle());
                String[] gener;
                gener = movieList.getGenres();
                Bundle bundle = new Bundle();
                bundle.putString("titles" ,movieList.getTitle());
                bundle.putString("year" , movieList.getYear());
                bundle.putStringArray("gener" , gener);
                bundle.putString("id" , movieList.getId());
                bundle.putString("alt" , movieList.getAlt());
                bundle.putString("subtype" , movieList.getSubtype());
                bundle.putSerializable("pictures" ,movieList.getImages().getLarge());
                Intent intent = new Intent(holder.itemView.getContext() , MovieCeshiActivity.class);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    public static class MovieListHolder extends RecyclerView.ViewHolder {
        public final ImageView iv_book_img;
        public final TextView tv_book_title;
        public final AppCompatRatingBar ratingBar_hots;
        public final TextView tv_hots_num;
        public final TextView tv_book_info;
        public final TextView tv_book_description;

        MovieListHolder(View itemView) {
            super(itemView);
            iv_book_img = (ImageView) itemView.findViewById(R.id.iv_book_img);
            tv_book_title = (TextView) itemView.findViewById(R.id.tv_book_title);
            ratingBar_hots = (AppCompatRatingBar) itemView.findViewById(R.id.ratingBar_hots);
            tv_hots_num = (TextView) itemView.findViewById(R.id.tv_hots_num);
            tv_book_info = (TextView) itemView.findViewById(R.id.tv_book_info);
            tv_book_description = (TextView) itemView.findViewById(R.id.tv_book_description);
        }
    }

}
