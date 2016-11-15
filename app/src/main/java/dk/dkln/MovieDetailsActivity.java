package dk.dkln;

import android.os.Bundle;

import dk.dkln.mvp.LayoutView;

public class MovieDetailsActivity extends BaseActivity implements LayoutView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData(Object result) {

    }
}
