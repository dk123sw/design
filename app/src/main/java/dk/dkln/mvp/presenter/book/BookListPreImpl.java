package dk.dkln.mvp.presenter.book;


import dk.dkln.bean.movie.BaseResponse;
import dk.dkln.mvp.ApiCompleteListener;
import dk.dkln.mvp.BaseView;
import dk.dkln.mvp.LayoutView;
import dk.dkln.mvp.model.book.BookListModelImpl;
import dk.dkln.mvp.model.book.IBookListModel;

public class BookListPreImpl implements IBookListPresenter, ApiCompleteListener {
    private LayoutView iBookDetailsView;
    private IBookListModel iBookDetailsModel;

    public BookListPreImpl(BaseView iBookDetailsView) {
        this.iBookDetailsView = (LayoutView) iBookDetailsView;
        iBookDetailsModel = new BookListModelImpl();
    }

    @Override
    public void loadBooks(String q, String tag, int start, int count) {
        iBookDetailsView.showProgress();
        iBookDetailsModel.loadBookList(q, tag, start, count,  this);
    }

    @Override
    public void cancelLoading() {
        iBookDetailsView.hideProgress();
    }

    @Override
    public void onComplected(Object result) {
        iBookDetailsView.hideProgress();
        iBookDetailsView.showData(result);
}

    @Override
    public void onFailed(BaseResponse msg) {
        iBookDetailsView.showMessage(msg.getMsg());
    }
}
