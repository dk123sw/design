package dk.dkln.mvp.view.book;

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
import dk.dkln.R;
import dk.dkln.base.BaseActivity;
import dk.dkln.mvp.view.WebActivity;

public class BookDetailsActivity extends BaseActivity {

    @BindView(R.id.pictures)
    ImageView pictures;

    @BindView(R.id.binding)
    TextView binding;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public boolean canBack() {
        return true;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_book_details;
    }

    private void initView() {
        if (getIntent().getSerializableExtra("pictures")!=null) {
            Glide.with(this)
                    .load(getIntent().getSerializableExtra("pictures"))
                    .into(pictures);
        }
        if (getIntent().getStringExtra("binding") != null) {
            binding.setText("[" +getIntent().getStringExtra("binding") + "]");
        }
        if (getIntent().getStringExtra("titles") != null) {
            titles.setText(getIntent().getStringExtra("titles"));
            toolbar.setTitle(getIntent().getStringExtra("titles"));
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorDisplayText));
        }
        if (getIntent().getStringExtra("summary") != null)
        {
            summary.setText(getIntent().getStringExtra("summary"));
        }
        if (getIntent().getStringExtra("year") != null) {
            year.setText("出版时间:" + getIntent().getStringExtra("year"));
        }
    }

    @OnClick(R.id.details)
    public void details(View v){
        String url = (String)getIntent().getStringExtra("alt") ;
        Intent intent = WebActivity.newIntent(this
                , url ,getIntent().getStringExtra("titles"));
        startActivity(intent);
    }
}
