package dk.dkln.mvp.model.book;

import com.google.gson.Gson;

import java.net.UnknownHostException;

import dk.dkln.bean.book.BookInfoResponse;
import dk.dkln.bean.movie.BaseResponse;
import dk.dkln.mvp.ApiCompleteListener;
import dk.dkln.mvp.http.DouBanApi;
import dk.dkln.mvp.http.ServiceFactory;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dk on 2016/11/14.
 */

public class BookListModelImpl implements IBookListModel {
    @Override
    public void loadBookList(String q, String tag, int start, int count,final ApiCompleteListener listener) {
        DouBanApi douBanApi = ServiceFactory.createService(DouBanApi.class);
        douBanApi.getBookList(q , tag ,start , count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<BookInfoResponse>>() {
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
                    public void onNext(Response<BookInfoResponse> bookInfoResponseResponse) {
                        if (bookInfoResponseResponse.isSuccessful()) {
                            String str = new Gson().toJson(bookInfoResponseResponse.body());
                            listener.onComplected(bookInfoResponseResponse.body());
                        } else {
                            listener.onFailed(new BaseResponse(bookInfoResponseResponse.code(),
                                    bookInfoResponseResponse.message()));
                        }
                    }
                });
    }

    @Override
    public void cancelLoading() {

    }
}
