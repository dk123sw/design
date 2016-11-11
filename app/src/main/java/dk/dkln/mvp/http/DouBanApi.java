package dk.dkln.mvp.http;

import dk.dkln.bean.movie.MovieInfoResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dk on 2016/11/11.
 */

public interface DouBanApi {

    @GET("/top250")
    Observable<Response<MovieInfoResponse>> getMovieList(@Query("start") int start,
                                                         @Query("count") int count);
}
