package dk.dkln.bean.book;

import java.util.List;

import dk.dkln.bean.movie.BaseResponse;


public class BookInfoResponse extends BaseResponse {
    private int count;
    private int start;
    private int total;
    protected List<BookListResponse> books;


    public BookInfoResponse() {
    }

    public BookInfoResponse(int code, String msg) {
        super(code, msg);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BookListResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookListResponse> books) {
        this.books = books;
    }
}
