package dk.dkln.mvp.presenter.movie;

import dk.dkln.bean.movie.BaseResponse;
import dk.dkln.mvp.ApiCompleteListener;
import dk.dkln.mvp.BaseView;
import dk.dkln.mvp.model.movie.IMovieSeriesList;
import dk.dkln.mvp.model.movie.MovieSeriesListModellmpl;

/**
 * Created by dk on 2016/11/11.
 */

public class MovieDetailPreImpl implements IMovieSeriesPresenter,ApiCompleteListener {

    private BaseView baseView;
    private IMovieSeriesList iMovieSeriesList;

    public MovieDetailPreImpl(BaseView view){
        this.baseView = view;
        iMovieSeriesList = new MovieSeriesListModellmpl();
    }

    @Override
    public void LoadSeriesPre(String resId) {
        iMovieSeriesList.LoadMovieSeriesList(resId , this);
    }

    @Override
    public void onComplected(Object result) {
      baseView.showData(result);
    }

    @Override
    public void onFailed(BaseResponse msg) {

    }
}
