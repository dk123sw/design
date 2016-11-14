package dk.dkln.mvp.presenter.movie;


import dk.dkln.bean.movie.BaseResponse;
import dk.dkln.mvp.ApiCompleteListener;
import dk.dkln.mvp.BaseView;
import dk.dkln.mvp.LayoutView;
import dk.dkln.mvp.model.movie.IMovieListModel;
import dk.dkln.mvp.model.movie.MovieListModelImpl;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieListPreImpl implements IMovieListPresenter,ApiCompleteListener {

    private LayoutView iBookListView;
    private IMovieListModel iMovieListModel;

    public MovieListPreImpl(BaseView view){
        this.iBookListView = (LayoutView) view;
        iMovieListModel = new MovieListModelImpl();
    }

    @Override
    public void loadMoives(int start, int count) {
        iBookListView.showProgress();
        iMovieListModel.loadMovieList(start , count ,this);
    }

    @Override
    public void cancelLoading() {
        iBookListView.hideProgress();
    }

    @Override
    public void onComplected(Object result) {
        iBookListView.hideProgress();
        iBookListView.showData(result);
    }

    @Override
    public void onFailed(BaseResponse msg) {
        iBookListView.showMessage(msg.getMsg());
    }
}
