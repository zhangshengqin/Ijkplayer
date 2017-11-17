package test.baway.com.zhoukao.model;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.baway.com.zhoukao.app.ApiService;
import test.baway.com.zhoukao.bean.MyBean;

/**
 * Created by 额头发 on 2017/11/6.
 */

public class MyModel implements MyModelInfo{

    @Override
    public void RequestSuccess(String url, final OnClientListener onClientListener) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        //结合rxjava
        Observable<MyBean> date = apiService.getDate();
        date.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onClientListener.OnError(e.getMessage().toString());
                    }

                    @Override
                    public void onNext(MyBean songListBean) {
                        List<MyBean.SongListBean> list = songListBean.getSong_list();
                        onClientListener.OnSuccess(list);
                    }
                });


    }
}
