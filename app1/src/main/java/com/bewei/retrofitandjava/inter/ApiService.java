package com.bewei.retrofitandjava.inter;

import android.net.wifi.hotspot2.pps.HomeSp;

import com.bewei.retrofitandjava.bean.Datas;
import com.bewei.retrofitandjava.bean.Home;
import com.bewei.retrofitandjava.bean.Homes;
import com.bewei.retrofitandjava.bean.News;
import com.bewei.retrofitandjava.bean.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/11/2 13:27
 */


public interface ApiService {
    /**
     * 结合Retrofit+RxJava
     * http://service.meiyinkeqiu.com/service/ads/cptj
     * @param
     * @return
     */
    @GET("/service/ads/cptj")
    Observable<News> getNoParams();

/**
 * 结合RxJava
 * @param user
 * @return
 * https://api.github.com/users/forever
 */
    @GET("users/{user}")
   Observable<User> getHasParams(@Path("user")String user);
//第三个接口,,兼容json解析功能，，集成rxjava  square  retrofit
    //https://api.github.com/repos/square/retrofit/contributors
    @GET("repos/{square}/{retrofit}/contributors")
 Observable<List<Datas>>   getHasParams2(@Path("square") String square, @Path("retrofit")String retrofit);

    @GET("type/1/p/1")
     Observable<Homes>  getHomes();









}
