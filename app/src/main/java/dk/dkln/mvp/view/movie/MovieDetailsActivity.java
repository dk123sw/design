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
import dk.dkln.BaseActivity;
import dk.dkln.R;
import dk.dkln.WebActivity;
/**
 *  TODO 有时间重做这布局~~
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
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        loadDate();
        initView();

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
            gener.setText("[" +getIntent().getStringArrayExtra("gener")[0] + "]");
        }
        if (getIntent().getStringExtra("titles") != null) {
            titles.setText(getIntent().getStringExtra("titles"));
            toolbar.setTitle(getIntent().getStringExtra("titles"));
        }
        if (getIntent().getStringExtra("subtype") != null)
            {
                summary.setText(getIntent().getStringExtra("subtype"));
            }
        if (getIntent().getStringExtra("year") != null) {
            year.setText(getIntent().getStringExtra("year"));
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
