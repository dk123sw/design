//package dk.dkln.mvp.model.book.impl;
//
//import com.google.gson.Gson;
//
//import dk.dkln.bean.movie.BaseResponse;
//import dk.dkln.mvp.ApiCompleteListener;
//import dk.dkln.mvp.http.IBookReviewsService;
//import dk.dkln.mvp.http.IBookSeriesService;
//import dk.dkln.mvp.http.ServiceFactory;
//import dk.dkln.mvp.model.book.IBookDetailModel;
//import retrofit2.Response;
//import rx.Subscriber;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.schedulers.Schedulers;
//
//
//
//public class BookDetailModelImpl implements IBookDetailModel {
//    @Override
//    public void loadReviewsList(String bookId, int start, int count, String fields, final ApiCompleteListener listener) {
//        IBookReviewsService iBookReviewsService = ServiceFactory.createService(IBookReviewsService.class);
//        iBookReviewsService.getBookReviews(bookId, start, count, fields)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Response<BookReviewsListResponse>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Response<BookReviewsListResponse> bookReviewsListResponseResponse) {
//                        if (bookReviewsListResponseResponse.isSuccessful()) {
//                            String str = new Gson().toJson(bookReviewsListResponseResponse.body());
//                            listener.onComplected(bookReviewsListResponseResponse.body());
//                        } else {
//                            listener.onFailed(new BaseResponse(bookReviewsListResponseResponse.code(), bookReviewsListResponseResponse.message()));
//                        }
//                    }
//                });
//    }
//
//    @Override
//    public void loadSeriesList(String bookId, int start, int count, String fields, final ApiCompleteListener listener) {
//        IBookSeriesService iBookSeriesService = ServiceFactory.createService(IBookSeriesService.class);
//        iBookSeriesService.getBookSeries(bookId, start, count, fields)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Response<BookSeriesListResponse>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Response<BookSeriesListResponse> bookSeriesListResponseResponse) {
//                        if (bookSeriesListResponseResponse.isSuccessful()) {
//                            String str = new Gson().toJson(bookSeriesListResponseResponse.body());
//                            listener.onComplected(bookSeriesListResponseResponse.body());
//                        } else {
//                            listener.onFailed(new BaseResponse(bookSeriesListResponseResponse.code(), bookSeriesListResponseResponse.message()));
//                        }
//                    }
//                });
//    }
//}
