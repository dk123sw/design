package dk.dkln.adapter;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
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
 * Created by dk on 2016/11/12.
 */

public class MovieListHotProvider extends ItemViewProvider<MovieListResponse ,
        MovieListHotProvider.MovieListHotHolder> {

//    TODO 下拉加载
    

    @NonNull
    @Override
    protected MovieListHotHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_hot_movie_list ,
                parent ,false);
        return new MovieListHotHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final MovieListHotHolder holder, @NonNull final MovieListResponse movieListResponse) {
//        ViewGroup.LayoutParams params=holder.pictures.getLayoutParams();
//        int width= ScreenUtils.getScreenWidthDp();
//        int ivWidth=(width-ScreenUtils.dipToPx(,80))/3;
//        params.width=ivWidth;
//        double height=(420.0/300.0)*ivWidth;
//        params.height=(int)height;
//        holder.pictures.setLayoutParams(params);
//          BaseFragment dk= MovieLiveFragment.newInstance();
//        if (holder.pictures.getLayoutParams() != null) {
//            WindowManager wm = (WindowManager)
//                    dk.getContext().getSystemService(Context.WINDOW_SERVICE);
//            int width = wm.getDefaultDisplay().getWidth();
//            ViewGroup.LayoutParams params = holder.pictures.getLayoutParams();
////        width= ScreenUtils.getScreenWidthDp(getActivity());
//            int ivWidth = (width - ScreenUtils.dipToPx(dk.getContext(), 80)) / 3;
//            params.width = ivWidth;
//            double height = (420.0 / 300.0) * ivWidth;
//            params.height = (int) height;
//            holder.pictures.setLayoutParams(params);
//        }
        //TODO  添加屏幕宽度的适配
        Glide.with(holder.itemView.getContext())
                .load(movieListResponse.getImages().getLarge())
                .into(holder.pictures);
        holder.movieName.setText(movieListResponse.getTitle());
        holder.rating.setText("评分: " + movieListResponse.getRating().getAverage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String url = (String)URL.URL_MOVIE + movieList.getId() + "/";
//                Intent intent = WebActivity.newIntent(holder.itemView.getContext()
//                 , url , movieList.getTitle());
                String[] gener;
                gener = movieListResponse.getGenres();
                Bundle bundle = new Bundle();
                bundle.putString("titles" ,movieListResponse.getTitle());
                bundle.putString("year" , movieListResponse.getYear());
                bundle.putStringArray("gener" , gener);
                bundle.putString("id" , movieListResponse.getId());
                bundle.putString("alt" , movieListResponse.getAlt());
                bundle.putString("subtype" , movieListResponse.getSubtype());
                bundle.putSerializable("pictures" ,movieListResponse.getImages().getLarge());
                Intent intent = new Intent(holder.itemView.getContext() , MovieCeshiActivity.class);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    public static class MovieListHotHolder extends RecyclerView.ViewHolder{

        public final ImageView pictures;
        public final TextView movieName;
        public final TextView rating;
        public final CardView cardView;
        public final float density1;
        public final int width3;
        public final int height3;

        MovieListHotHolder(View itemView){
            super(itemView);
            Resources res = itemView.getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            density1 =dm.density;
            width3 = dm.widthPixels;
            height3 = dm.heightPixels;
            pictures = (ImageView) itemView.findViewById(R.id.pictures);
            movieName = (TextView) itemView.findViewById(R.id.movieName);
            rating = (TextView) itemView.findViewById(R.id.rating);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }

}
