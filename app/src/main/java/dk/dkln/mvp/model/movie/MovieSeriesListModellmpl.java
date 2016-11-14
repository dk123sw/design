package dk.dkln.mvp.model.movie;

import dk.dkln.bean.movie.BaseResponse;
import dk.dkln.bean.movie.MoiveSeriesListRespnse;
import dk.dkln.mvp.ApiCompleteListener;
import dk.dkln.mvp.http.DouBanApi;
import dk.dkln.mvp.http.ServiceFactory;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dk on 2016/11/11.
 */

public class MovieSeriesListModellmpl implements IMovieSeriesList {

    @Override
    public void LoadMovieSeriesList(String resId , final ApiCompleteListener listener) {
        DouBanApi douBanApi = ServiceFactory.createService(DouBanApi.class);
        douBanApi.getMovieSeriesList(resId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<MoiveSeriesListRespnse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<MoiveSeriesListRespnse> moiveSeriesListRespnseResponse) {
                        if (moiveSeriesListRespnseResponse.isSuccessful()){
                            listener.onComplected(moiveSeriesListRespnseResponse.body());
                        }else {
                            listener.onFailed(new BaseResponse(moiveSeriesListRespnseResponse.code(),
                                    moiveSeriesListRespnseResponse.message()));
                        }
                    }
                });
    }
}
