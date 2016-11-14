package dk.dkln.mvp.presenter.movie;

import dk.dkln.bean.movie.BaseResponse;
import dk.dkln.mvp.ApiCompleteListener;
import dk.dkln.mvp.BaseView;
import dk.dkln.mvp.LayoutView;
import dk.dkln.mvp.model.movie.IMovieListModel;
import dk.dkln.mvp.model.movie.MovieHotListModellmpl;

/**
 * Created by dk on 2016/11/12.
 */

public class MovieHotListPreImpl implements IMovieListPresenter ,ApiCompleteListener{

    private LayoutView layoutView;
    private IMovieListModel iMovieListModel;

    public MovieHotListPreImpl(BaseView view){
        this.layoutView = (LayoutView) view;
        iMovieListModel = new MovieHotListModellmpl();
    }

    @Override
    public void loadMoives(int start, int count) {
         layoutView.showProgress();
        iMovieListModel.loadMovieList(start , count ,this);
    }

    @Override
    public void cancelLoading() {
        layoutView.hideProgress();
    }

    @Override
    public void onComplected(Object result) {
        layoutView.hideProgress();
        layoutView.showData(result);
    }

    @Override
    public void onFailed(BaseResponse msg) {
        layoutView.showMessage(msg.getMsg());
    }
}
