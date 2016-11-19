//package dk.dkln.mvp.presenter.book.impl;
//
//import dk.dkln.bean.movie.BaseResponse;
//import dk.dkln.mvp.ApiCompleteListener;
//import dk.dkln.mvp.BaseView;
//import dk.dkln.mvp.model.book.IBookDetailModel;
//import dk.dkln.mvp.model.book.impl.BookDetailModelImpl;
//import dk.dkln.mvp.presenter.book.IBookDetailPresenter;
//
//
//public class BookDetailPreImpl implements IBookDetailPresenter,ApiCompleteListener {
//    private BaseView iBaseView;
//    private IBookDetailModel iBookDetailModel;
//
//    public BookDetailPreImpl(BaseView ibookDetalView) {
//        this.iBaseView = ibookDetalView;
//        iBookDetailModel = new BookDetailModelImpl();
//    }
//
//    @Override
//    public void loadReviews(String bookId, int start, int count, String fields) {
//        iBookDetailModel.loadReviewsList(bookId,start,count,fields,this);
//    }
//
//    @Override
//    public void loadSeries(String seriesId, int start, int count, String fields) {
//        iBookDetailModel.loadSeriesList(seriesId, start, count, fields, this);
//    }
//
//    @Override
//    public void onComplected(Object result) {
//        iBaseView.showData(result);
//    }
//
//    @Override
//    public void onFailed(BaseResponse msg) {
//
//    }
//}
