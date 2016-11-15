package dk.dkln;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;

/**
 * Created by dk on 2016/11/4.
 */

public class BaseActivity extends AppCompatActivity {

    @Nullable @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Nullable @BindView(R.id.appbarLayout)
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar();
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        if (canBack()) {
            ActionBar actionBar = getSupportActionBar();
//            回到主菜单的图标
            if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        if (Build.VERSION.SDK_INT >= 21) {
//            appBarLayout.setElevation(10.6f);
//        }
    }

    public boolean canBack() {
        return false;
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
