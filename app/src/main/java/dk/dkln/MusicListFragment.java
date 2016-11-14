package dk.dkln;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dk.dkln.mvp.LayoutView;
import dk.dkln.utils.MusicApiUtils;

/**
 * Created by dk on 2016/11/14.
 */

public class MusicListFragment extends BaseFragment implements LayoutView,
MultiSwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.id_swiperefreshlayout)
    SwipeRefreshLayout idSwiperefreshlayout;
    private int position;
    private int lastVisibleItem;
    private LinearLayoutManager mLayoutManager;
    private List<String> listTag;

    public static MusicListFragment newInstance(int position, String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putInt("position", position);
        MusicListFragment fragment = new MusicListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args= getArguments();
        if(args!=null){
            position=args.getInt("position");
        }
//        musicList=new ArrayList<>();
        String[] strTags= MusicApiUtils.getApiTag(position);
        listTag= Arrays.asList(strTags);
//        scrollRecycleView();
//        idSwiperefreshlayout.setColorSchemeColors(ThemeUtils.getThemeColor());
//        idSwiperefreshlayout.setOnRefreshListener(this);
//        doubanMusicPresenter=new DoubanMusicPresenter(getActivity());
//        String tag=BookApiUtils.getRandomTAG(listTag);
//        doubanMusicPresenter.searchMusicByTag(this,tag,false);
//        adapter=new MusicAdapter(getActivity());
//        mLayoutManager = new LinearLayoutManager(getContext());
//        recyclerview.setLayoutManager(mLayoutManager);
//        recyclerview.setAdapter(adapter);
    }

//    /**
//     * recyclerView Scroll listener , maybe in here is wrong ?
//     */
//    public void scrollRecycleView() {
//        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
//                    if (mLayoutManager.getItemCount() == 1) {
//                        if(adapter!=null) {
//                            adapter.updateLoadStatus(adapter.LOAD_NONE);
//                        }
//                        return;
//
//                    }
//                    if (lastVisibleItem + 1 == mLayoutManager.getItemCount()) {
//                        if(adapter!=null) {
//                            adapter.updateLoadStatus(adapter.LOAD_PULL_TO);
//                            // isLoadMore = true;
//                            adapter.updateLoadStatus(adapter.LOAD_MORE);
//                        }
//                        //new Handler().postDelayed(() -> getBeforeNews(time), 1000);
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                String tag=BookApiUtils.getRandomTAG(listTag);
//                                doubanMusicPresenter.searchMusicByTag(MusicContentFragment.this,tag,true);
//                            }
//                        },1000) ;
//                    }
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
//            }
//        });
//    }


    @Override
    public void onRefresh() {

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
