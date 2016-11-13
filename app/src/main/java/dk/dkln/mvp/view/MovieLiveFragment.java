package dk.dkln.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dk.dkln.BaseFragment;
import dk.dkln.MultiSwipeRefreshLayout;
import dk.dkln.R;
import dk.dkln.adapter.MovieListHotProvider;
import dk.dkln.bean.movie.MovieInfoResponse;
import dk.dkln.bean.movie.MovieListResponse;
import dk.dkln.mvp.LayoutView;
import dk.dkln.mvp.presenter.MovieHotListPreImpl;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by dk on 2016/11/9.
 */

public class MovieLiveFragment extends BaseFragment implements LayoutView ,
        MultiSwipeRefreshLayout.OnRefreshListener{


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.swipe_refresh_layout)
    MultiSwipeRefreshLayout multiSwipeRefreshLayout;

    private boolean mIsFirstTimeTouchBottom = true;
    private int mPage = 0;
    private int  Page_Size = 10;
    private static final int PRELOAD_SIZE = 6;

    private Context context;
    MovieHotListPreImpl movieHotListPre;
    MultiTypeAdapter adapter;


    public static MovieLiveFragment newInstance() {

        Bundle args = new Bundle();
        MovieLiveFragment fragment = new MovieLiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_move_use, container, false);
        ButterKnife.bind(this ,view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(context ,2);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.addOnScrollListener(getOnBottomListener(layoutManager));
    }

    @Override
    public void initEvent() {
        multiSwipeRefreshLayout.setOnRefreshListener(this);
        movieHotListPre = new MovieHotListPreImpl(this);
        onRefresh();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
        Log.e("showMessage", msg);
        if (msg == "timeout") {
            onRefresh();
        }
    }

    @Override
    public void showProgress() {
        multiSwipeRefreshLayout.setRefreshing(true);
//        Toast.makeText(getContext() , "加载" ,Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void hideProgress() {
        multiSwipeRefreshLayout.setRefreshing(false);
//        Toast.makeText(getContext() , "完成" ,Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void showData(Object result) {
        MovieInfoResponse response = (MovieInfoResponse) result;
//            adapter.applyGlobalMultiTypePool();
        adapter = new MultiTypeAdapter(response.getSubjects());
        adapter.register(MovieListResponse.class, new MovieListHotProvider());
        recyclerview.setAdapter(adapter);
    }

    RecyclerView.OnScrollListener getOnBottomListener(final GridLayoutManager layoutManager) {
        return new RecyclerView.OnScrollListener() {
            @Override public void onScrolled(RecyclerView rv, int dx, int dy) {
                boolean isBottom =
                        layoutManager.findLastVisibleItemPosition() >=
                                adapter.getItemCount() - PRELOAD_SIZE;
                if (!multiSwipeRefreshLayout.isRefreshing() && isBottom) {
                    if (!mIsFirstTimeTouchBottom) {
                        multiSwipeRefreshLayout.setRefreshing(true);
                        mPage += 3;
                        onRefresh();
                    } else {
                        mIsFirstTimeTouchBottom = false;
                    }
                }
            }
        };
    }

//    加载数超出已有的数量导致app退出用if()做判断
    @Override
    public void onRefresh() {
        if((Page_Size + mPage) <= 20) {
            movieHotListPre.loadMoives(0, Page_Size + mPage);
            Toast.makeText(getContext(), "成功加载", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getContext(), "无数据加载", Toast.LENGTH_SHORT).show();
            multiSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
