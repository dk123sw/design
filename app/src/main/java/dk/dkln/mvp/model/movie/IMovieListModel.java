package dk.dkln.mvp.model.movie;

import dk.dkln.mvp.ApiCompleteListener;

/**
 * Created by dk on 2016/10/29.
 */

public interface IMovieListModel {

    void loadMovieList(int start, int count, ApiCompleteListener listener);

    void cancelLoading();
}
