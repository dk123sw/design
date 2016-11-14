package dk.dkln.mvp.http;

import dk.dkln.bean.book.BookInfoResponse;
import dk.dkln.bean.movie.MoiveSeriesListRespnse;
import dk.dkln.bean.movie.MovieInfoResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dk on 2016/11/11.
 */

public interface DouBanApi {

    @GET("movie/top250")
    Observable<Response<MovieInfoResponse>> getMovieList(@Query("start") int start,
                                                         @Query("count") int count);
    /**
     *  /v2/movie/subject/1764796
     */

    @GET("movie/subject/{resId}")
    Observable<Response<MoiveSeriesListRespnse>> getMovieSeriesList(@Path("resId") String resId);

    /**
     * 热映榜
     * https://api.douban.com/v2/movie/in_theaters
     */
    @GET("movie/in_theaters")
    Observable<Response<MovieInfoResponse>> gethotMovieList(@Query("start") int start,
                                                            @Query("count") int count);
    /**
     * https://api.douban.com/v2/book/search?tag=%E6%8E%A8%E8%8D%90&start=0&count=10
     */
    @GET("book/search")
    Observable<Response<BookInfoResponse>> getBookList(@Query("q") String q, @Query("tag") String tag,
                                                       @Query("start") int start, @Query("count") int count);
}
