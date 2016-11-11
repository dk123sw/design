package dk.dkln.mvp.model;

import dk.dkln.mvp.ApiCompleteListener;

/**
 * Created by dk on 2016/11/11.
 */

public interface IMovieSeriesList {

    void LoadMovieSeriesList(String resId , ApiCompleteListener listener);
}
