package dk.dkln.mvp.model;

import java.net.UnknownHostException;

import dk.dkln.bean.movie.BaseResponse;
import dk.dkln.bean.movie.MovieInfoResponse;
import dk.dkln.mvp.ApiCompleteListener;
import dk.dkln.mvp.http.DouBanApi;
import dk.dkln.mvp.http.ServiceFactory;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dk on 2016/11/12.
 */

public class MovieHotListModellmpl implements IMovieListModel {
    @Override
    public void loadMovieList(int start, int count, final ApiCompleteListener listener) {
        DouBanApi douBanApi = ServiceFactory.createService(DouBanApi.class);
        douBanApi.gethotMovieList(start ,count)
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
                            return ;
                        }else {
                            listener.onFailed(new BaseResponse(404 , e.getMessage()));
                        }
                    }

                    @Override
                    public void onNext(Response<MovieInfoResponse> movieInfoResponseResponse) {
                        if (movieInfoResponseResponse.isSuccessful()){
                            listener.onComplected(movieInfoResponseResponse.body());
                        }else {
                            listener.onFailed(new BaseResponse(movieInfoResponseResponse.code()
                            ,movieInfoResponseResponse.message()));
                        }
                    }
                });
    }

    @Override
    public void cancelLoading() {

    }
}
