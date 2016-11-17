package dk.dkln.mvp.view.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dk.dkln.base.BaseFragment;
import dk.dkln.base.MultiSwipeRefreshLayout;
import dk.dkln.R;
import dk.dkln.adapter.BookListsProvider;
import dk.dkln.bean.book.BookInfoResponse;
import dk.dkln.bean.book.BookListResponse;
import dk.dkln.mvp.LayoutView;
import dk.dkln.mvp.presenter.book.impl.BookListPreImpl;
import dk.dkln.utils.BookApiUtils;
import me.drakeet.multitype.MultiTypeAdapter;


/**
 * Created by dk on 2016/11/14.
 */

public class BookListFragment extends BaseFragment implements LayoutView,
        SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.id_swiperefreshlayout)
    MultiSwipeRefreshLayout multiSwipeRefreshLayout;

    private int position;
    public MultiTypeAdapter adapter;
    public static int page_Size = 10;
    public BookListPreImpl bookListPre;
    public String tag = "null";

    public static BookListFragment newInstance(int position, String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putInt("position", position);
        BookListFragment fragment = new BookListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);
        ButterKnife.bind(this, view);
        Bundle args= getArguments();
        if(args!=null){
            position=args.getInt("position");
        }
//        musicList=new ArrayList<>();
        tag= BookApiUtils.getApiTag(position);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        listTag= Arrays.asList(strTags);
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
    public void initView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void initEvent() {
        multiSwipeRefreshLayout.setOnRefreshListener(this);
        bookListPre = new BookListPreImpl(this);
        onRefresh();
    }

    @Override
    public void onRefresh() {

        bookListPre.loadBooks(null ,tag , 0 , page_Size);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
        Log.e("showMessage", msg);
        if ("timeout" == msg ){
            multiSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showProgress() {
        multiSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        multiSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showData(Object result) {
        BookInfoResponse response = (BookInfoResponse) result;
//            adapter.applyGlobalMultiTypePool();
        adapter = new MultiTypeAdapter(response.getBooks());
        adapter.register(BookListResponse.class, new BookListsProvider());
        recyclerview.setAdapter(adapter);
    }
}
