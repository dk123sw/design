package dk.dkln.mvp.model;

import com.google.gson.Gson;

import java.net.UnknownHostException;

import dk.dkln.bean.BaseResponse;
import dk.dkln.bean.MovieInfoResponse;
import dk.dkln.mvp.ApiCompleteListener;
import dk.dkln.mvp.http.IMovieListService;
import dk.dkln.mvp.http.ServiceFactory;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieListModelImpl implements IMovieListModel {

    @Override
    public void loadMovieList(int start, int count,final ApiCompleteListener listener) {
        IMovieListService service = ServiceFactory.createService(IMovieListService.class);
        service.getMovieList(start ,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<MovieInfoResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof UnknownHostException) {
                            listener.onFailed(null);
                            return;
                        }
                        listener.onFailed(new BaseResponse(404, e.getMessage()));
                    }

                    @Override
                    public void onNext(Response<MovieInfoResponse> movieInfoResponseResponse) {
                        if (movieInfoResponseResponse.isSuccessful()) {
                            String str = new Gson().toJson(movieInfoResponseResponse.body());
                            listener.onComplected(movieInfoResponseResponse.body());
                        } else {
                            listener.onFailed(new BaseResponse(movieInfoResponseResponse.code(),
                                    movieInfoResponseResponse.message()));
                        }
                    }
                });
    }

    @Override
    public void cancelLoading() {

    }
}
