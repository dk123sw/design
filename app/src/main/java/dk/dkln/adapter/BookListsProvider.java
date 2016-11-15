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
import dk.dkln.bean.book.BookListResponse;
import dk.dkln.mvp.view.book.BookDetailsActivity;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by dk on 2016/11/14.
 */

public class BookListsProvider
        extends ItemViewProvider<BookListResponse, BookListsProvider.BookListHolder> {

    @NonNull
    @Override
    protected BookListHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_book_list, parent, false);
        return new BookListHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull final BookListHolder holder, @NonNull final BookListResponse bookList) {
        Glide.with(holder.itemView.getContext())
                .load(bookList.getImages().getLarge())
                .into(holder.iv_book_img);
        holder.tv_book_title.setText(bookList.getTitle());
        holder.ratingBar_hots.setRating(Float.valueOf(bookList.getRating().getAverage()) / 2);
        holder.tv_hots_num.setText(bookList.getRating().getAverage());
        holder.tv_book_info.setText(bookList.getInfoString());
        holder.tv_book_description.setText("\u3000" + bookList.getSummary());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String url = (String)URL.URL_MOVIE + bookList.getId() + "/";
//                Intent intent = WebActivity.newIntent(holder.itemView.getContext()
//                 , url , bookList.getTitle());
                Bundle bundle = new Bundle();
                bundle.putString("titles" ,bookList.getTitle());
                bundle.putString("year" , bookList.getPubdate());
                bundle.putString("binding" , bookList.getBinding());
                bundle.putString("alt" , bookList.getAlt());
                bundle.putString("summary" , bookList.getSummary());
                bundle.putSerializable("pictures" ,bookList.getImages().getLarge());
                Intent intent = new Intent(holder.itemView.getContext() , BookDetailsActivity.class);
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    public static class BookListHolder extends RecyclerView.ViewHolder {
        public final ImageView iv_book_img;
        public final TextView tv_book_title;
        public final AppCompatRatingBar ratingBar_hots;
        public final TextView tv_hots_num;
        public final TextView tv_book_info;
        public final TextView tv_book_description;

        BookListHolder(View itemView) {
            super(itemView);
            iv_book_img = (ImageView) itemView.findViewById(R.id.iv_book_img);
            tv_book_title = (TextView) itemView.findViewById(R.id.tv_book_title);
            ratingBar_hots = (AppCompatRatingBar) itemView.findViewById(R.id.ratingBar_hots);
            tv_hots_num = (TextView) itemView.findViewById(R.id.tv_hots_num);
            tv_book_info = (TextView) itemView.findViewById(R.id.tv_book_info);
            tv_book_description = (TextView)    itemView.findViewById(R.id.tv_book_description);
        }
    }

}