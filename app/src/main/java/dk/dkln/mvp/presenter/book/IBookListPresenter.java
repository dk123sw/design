package dk.dkln.mvp.presenter.book;



public interface IBookListPresenter {
    void loadBooks(String q, String tag, int start, int count);

    void cancelLoading();
}
