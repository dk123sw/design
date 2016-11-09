package dk.dkln.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import dk.dkln.BaseFragment;
import dk.dkln.R;
import dk.dkln.viewinterface.LayoutView;

/**
 * Created by dk on 2016/11/9.
 */

public class MovieTopFragment extends BaseFragment implements LayoutView ,
        SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.id_swiperefreshlayout)
    SwipeRefreshLayout idSwiperefreshlayout;

    private DoubanFilmPresenter doubanFilmPresenter;
    private Top250FilmAdapter adapter;

    private LinearLayoutManager mLayoutManager;


    private int lastVisibleItem;
    private int pageCount;
    private final int PAGE_SIZE=10;
    private Root mRoot;

    public static MovieTopFragment newInstance() {

        Bundle args = new Bundle();
        MovieTopFragment fragment = new MovieTopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_move_use, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doubanFilmPresenter=new DoubanFilmPresenter(getActivity());

        doubanFilmPresenter.getTop250(this,pageCount*PAGE_SIZE,PAGE_SIZE,false);
        mLayoutManager = new LinearLayoutManager(getContext());

        recyclerview.setLayoutManager(mLayoutManager);
        scrollRecycleView();
        idSwiperefreshlayout.setColorSchemeColors(ThemeUtils.getThemeColor());
        idSwiperefreshlayout.setOnRefreshListener(this);
    }





    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showData(Object result) {

    }

    @Override
    public void onRefresh() {

    }
}

