package dk.dkln.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dk.dkln.R;

/**
 * Created by dk on 2016/11/4.
 */

public abstract class BaseActivity extends AppCompatActivity {

    abstract protected int provideContentViewId();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbarLayout)
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentViewId());
        ButterKnife.bind(this);
        initToolbar();
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        if (canBack()) {
            ActionBar actionBar = getSupportActionBar();
//            toolbar.setBackground(getResources().getDrawable(R.drawable.toolbar));
//            回到主菜单的图标
            if (actionBar != null) {
//                actionBar.setDisplayHomeAsUpEnabled(true);
                toolbar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        backThActivity();
                    }
                });
            }
        }else {
            if (Build.VERSION.SDK_INT >= 21) {
                toolbar.setAlpha(1.f);
                View decorView = getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
//                getWindow().setNavigationBarColor(Color.TRANSPARENT);

                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }

    public void backThActivity() {
        finish();
        overridePendingTransition(R.anim.trans_pre_in, R.anim.trans_pre_out);
//       TODO 加过渡拉
    }

    public boolean canBack() {
        return false;
    }

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

        /**
         * 根据传入的类(class)打开指定的activity
         * @param pClass
         */
    protected void startThActivity(Class<?> pClass) {
        Intent _Intent = new Intent();
        _Intent.setClass(this, pClass);
        startActivity(_Intent);
        overridePendingTransition(R.anim.trans_next_in, R.anim.trans_next_out);
    }

    protected void startThActivityByIntent(Intent pIntent){
        startActivity(pIntent);
        overridePendingTransition(R.anim.trans_next_in, R.anim.trans_next_out);
    }
}
