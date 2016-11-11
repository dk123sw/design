package dk.dkln.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
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
import dk.dkln.bean.movie.MovieInfoResponse;
import dk.dkln.bean.movie.MovieListResponse;
import dk.dkln.mvp.LayoutView;
import dk.dkln.adapter.MovieListProvider;
import dk.dkln.mvp.presenter.MovieListPreImpl;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by dk on 2016/11/9.
 */

public class MovieTopFragment extends BaseFragment implements LayoutView,
        MultiSwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.swipe_refresh_layout)
    MultiSwipeRefreshLayout swiperefresh;

    MovieListPreImpl movieListPre;
    MultiTypeAdapter adapter;


    private final int PAGE_SIZE=10;

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
        ButterKnife.bind(this ,view);
        return view;
    }




    public void initView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    public void initEvent() {
        swiperefresh.setOnRefreshListener(this);
        movieListPre = new MovieListPreImpl(this);
        onRefresh();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
        Log.e("showMessage", msg);
    }

    @Override
    public void showProgress() {
        swiperefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swiperefresh.setRefreshing(false);
    }

    @Override
    public void showData(Object result) {
            MovieInfoResponse response = (MovieInfoResponse) result;
//            adapter.applyGlobalMultiTypePool();
            adapter = new MultiTypeAdapter(response.getSubjects());
            adapter.register(MovieListResponse.class, new MovieListProvider());
            recyclerview.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        movieListPre.loadMoives(0 ,PAGE_SIZE);
    }

}

