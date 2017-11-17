package test.baway.com.retrofitand;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 额头发 on 2017/11/3.
 */

public interface ApiService {
    @GET("type/1/p/1")
    Observable<News> getData();

}
