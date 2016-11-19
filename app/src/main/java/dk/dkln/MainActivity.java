package dk.dkln;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dk.dkln.base.BaseActivity;
import dk.dkln.mvp.view.WebActivity;
import dk.dkln.mvp.view.book.BookFragment;
import dk.dkln.mvp.view.game.Calculator;
import dk.dkln.mvp.view.game.GameActivity;
import dk.dkln.mvp.view.game.GameFragment;
import dk.dkln.mvp.view.game.ZxingActivity;
import dk.dkln.mvp.view.movie.MovieFragment;


/**
 * Created by dk on 2016/11/7.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.drawerLayout_home)
    DrawerLayout drawerLayout;
    @BindView(R.id.appbarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.id_navigationView)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;


    private ActionBarDrawerToggle actionBarDrawerToggle;
    protected MovieFragment movieFragment;
    protected GameFragment gameFragment;
    protected BookFragment bookFragment;
    protected List<Fragment> listFragment;
    protected int currItem; 

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initFragment();
        initViewpager();
        initNavigaton();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }


    /**
     * 初始化fragment
     */
    private void initFragment(){
        movieFragment = MovieFragment.newInstance();
        bookFragment = BookFragment.newInstance();
        gameFragment = GameFragment.newInstance();
        listFragment = new ArrayList<>();
        listFragment.add(movieFragment);
        listFragment.add(bookFragment);
        listFragment.add(gameFragment);
    }

    private void initViewpager(){
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_movie:
                        currItem = 0;
                        break;
                    case R.id.rb_music:
                        currItem = 1;
                        break;
                    case R.id.rb_game:
                        currItem = 2;
                        break;
                    default:
                        currItem = 0;
                }   
                viewPager.setCurrentItem(currItem);
            }
        });


        viewPager.setAdapter(new FragmentPagerAdapter(
                getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return listFragment.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return listFragment.get(arg0);
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                super.destroyItem(container, position, object);
            }

        });
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    radioGroup.check(R.id.rb_movie);
                    break;
                case 1:
                    radioGroup.check(R.id.rb_music);
                    break;
                case 2:
                    radioGroup.check(R.id.rb_game);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };


    /**
     * ActionBarDrawerToggle
     */
    private class ActionBarDrawerToggle extends android.support.v7.app.ActionBarDrawerToggle
    {

        public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar,
                                     int openDrawerContentDescRes, int closeDrawerContentDescRes)
        {

            super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
        }

        @Override
        public void onDrawerClosed(View drawerView)
        {

            super.onDrawerClosed(drawerView);
            invalidateOptionsMenu();
        }

        @Override
        public void onDrawerOpened(View drawerView)
        {

            super.onDrawerOpened(drawerView);
            invalidateOptionsMenu();
        }
    }

    /**
     *将NavigationView和ToolBar结合
     */
    private void initNavigaton() {
     //设置drawer的开关监听
     drawerLayout.addDrawerListener(new MyDrawerListener());

     actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout,
             toolbar, R.string.app_name, R.string.app_name);

     drawerLayout.post(new Runnable() {

         @Override
         public void run() {

             actionBarDrawerToggle.syncState();
         }
     });
     drawerLayout.addDrawerListener(actionBarDrawerToggle);

     /**
      * 设置抽屉栏每个选项要触发的界面
      */
     navigationView = (NavigationView) findViewById(R.id.id_navigationView);
     navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             switch (item.getItemId()) {
                 case R.id.item_home:
                     // github
                     String url = "https://github.com/dk123sw";
                     Intent intent = WebActivity.newIntent(MainActivity.this
                             , url ,"我的Github");
                     startThActivityByIntent(intent);
                     break;
                 case R.id.item_download:
                     // 关于我
                     startThActivity(AboutMeActivity.class);
                     break;
                 case R.id.item_favourite:
                     // zxing
                     startThActivity(ZxingActivity.class);
                     break;
                 case R.id.item_history:
                     // calculator
                     startThActivity(Calculator.class);
                     break;
                 case R.id.item_group:
                     // game
                    startThActivity(GameActivity.class);
                     break;
                 case R.id.item_settings:
                     // exit
                     if (Build.VERSION.SDK_INT >= 21){
                         finishAndRemoveTask();
                         break;
                     }
                     return true;
             }
             return false;
         }
     });
     }

    /** drawer的监听 */
    private class MyDrawerListener implements DrawerLayout.DrawerListener {
        @Override
        public void onDrawerOpened(View drawerView) {// 打开drawer
            if (actionBarDrawerToggle != null)
            {
                actionBarDrawerToggle.onDrawerOpened(drawerView);
            }//开关状态改为opened
        }

        @Override
        public void onDrawerClosed(View drawerView) {// 关闭drawer
            if (actionBarDrawerToggle != null)
            {
                actionBarDrawerToggle.onDrawerClosed(drawerView);
            }//开关状态改为closed
        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {// drawer滑动的回调
            if (actionBarDrawerToggle != null)
            {
                actionBarDrawerToggle.onDrawerSlide(drawerView, slideOffset);
            }
        }

        @Override
        public void onDrawerStateChanged(int newState) {// drawer状态改变的回调
            if (actionBarDrawerToggle != null)
            {
                actionBarDrawerToggle.onDrawerStateChanged(newState);
            }
        }
    }


}
