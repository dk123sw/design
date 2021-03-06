package dk.dkln.mvp.view.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dk.dkln.base.BaseActivity;
import dk.dkln.R;
import dk.dkln.mvp.view.WebActivity;
/**
 *  TODO 有时间重做这布局~~
 *  @ 废弃用MovieCeshiActivity代替
 */
public class MovieDetailsActivity extends BaseActivity {

    @BindView(R.id.pictures)
    ImageView pictures;
    @BindView(R.id.gener)
    TextView gener;
    @BindView(R.id.titles)
    TextView titles;
    @BindView(R.id.summary)
    TextView summary;
    @BindView(R.id.year)
    TextView year;
    @Nullable @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Nullable @BindView(R.id.appbarlayout)
    AppBarLayout appbarlayout;

//    public MovieListResponse listresponse;
//    MovieListPreImpl movieListPre;
//    public View view;
//    public Context content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        loadDate();
        initView();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_movie_details;
    }

    @Override
    public boolean canBack() {
        return true;
    }

    private void loadDate() {
//        listresponse = (MovieListResponse) getIntent().
//                getSerializableExtra(BookListResponse.serialVersionName);
//        movieListPre = new MovieListPreImpl(this);
    }

    private void initView() {
        if (getIntent().getSerializableExtra("pictures")!=null) {
            Glide.with(this)
                    .load(getIntent().getSerializableExtra("pictures"))
                    .into(pictures);
        }
        if (getIntent().getStringArrayExtra("gener") != null) {
            gener.setText("类型:" + "[" +getIntent().getStringArrayExtra("gener")[0] + "]");
        }
        if (getIntent().getStringExtra("titles") != null) {
            titles.setText(getIntent().getStringExtra("titles"));
            toolbar.setTitle(getIntent().getStringExtra("titles"));
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorDisplayText));
        }
        if (getIntent().getStringExtra("subtype") != null)
            {
                summary.setText(getIntent().getStringExtra("subtype"));
            }
        if (getIntent().getStringExtra("year") != null) {
            year.setText("公映时间:" + getIntent().getStringExtra("year"));
        }
    }

    @OnClick(R.id.details)
    public void details(View v){
                String url = (String)getIntent().getStringExtra("alt") ;
                Intent intent = WebActivity.newIntent(this
                        , url ,getIntent().getStringExtra("titles"));
//                intent.putExtras(bundle);
                startActivity(intent);
    }

}
