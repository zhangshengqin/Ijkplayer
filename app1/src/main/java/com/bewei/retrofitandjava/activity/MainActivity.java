package com.bewei.retrofitandjava.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bewei.retrofitandjava.R;
import com.bewei.retrofitandjava.api.Api;
import com.bewei.retrofitandjava.bean.Datas;
import com.bewei.retrofitandjava.bean.Homes;
import com.bewei.retrofitandjava.bean.News;
import com.bewei.retrofitandjava.bean.User;
import com.bewei.retrofitandjava.inter.ApiService;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    TextView  mtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          mtv= (TextView) findViewById(R.id.tv);

      //  getNoParams();
      //  getHasParams();
       // getHasParams2();
        gethome();
    }

    private void getHasParams2() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        //通过动态代理得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        //得到Observable
        Observable<List<Datas>> observable = apiService.getHasParams2("square", "retrofit");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //添加flatMap操作符
                .flatMap(new Func1<List<Datas>, Observable<Datas>>() {
                    @Override
                    public Observable<Datas> call(List<Datas> datases) {
                        return Observable.from(datases);
                    }
                }).subscribe(new Subscriber<Datas>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("xxx",e.getMessage());
            }

            @Override
            public void onNext(Datas datas) {
                String avatar_url = datas.getAvatar_url();
                Log.i("xxx",avatar_url);

            }
        });
    }


    private void gethome(){
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.HOME_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        //通过动态代理得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<Homes> homes = apiService.getHomes();
        homes.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Homes>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Homes homes) {
                        Log.d("onNext", "onNext: "+homes.getData().get(0).getNews_title());


                    }
                });



    }


    private void getHasParams() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        //通过动态代理得到网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        //得到Observable
        Observable<User> observable = apiService.getHasParams("forever");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //添加map变换操作符
                .map(new Func1<User, User>() {
                    @Override
                    public User call(User user) {
                        return user;
                    }
                }).subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {
                   //消费事件
                String avatar_url = user.getAvatar_url();
                Log.i("xxx",avatar_url);
            }
        });
    }
   //
    private void getNoParams() {
        //创建Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_PATH).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
       //通过动态代理得到网络接口对象
        //http://service.meiyinkeqiu.com/service/ads/cptj
        //"http://service.meiyinkeqiu.com/service/"
       //  retrofit.create(ApiServices);
        ApiService apiService = retrofit.create(ApiService.class);

        //得到Observable
        Observable<News> observable = apiService.getNoParams();//获取数据源
        observable.subscribeOn(Schedulers.io())//IO线程做耗时操作
                .observeOn(AndroidSchedulers.mainThread())//在主线程更新UI
                .subscribe(new Observer<News>() {
                    //完成
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this,"onCompleted",Toast.LENGTH_LONG).show();
                        Log.d("MainActivity", "onCompleted: ");
                    }
                    //异常
                    @Override
                    public void onError(Throwable e) {
                        Log.d("MainActivity", "onError: "+e.getMessage());
                    }
                   // 加载中
                    @Override
                    public void onNext(News news) {
                        Log.d("MainActivity", "onNext: ");
                        List<News.AdsBean> ads = news.getAds();
                        for (int i = 0; i < ads.size(); i++) {

                            Log.i("xxx",ads.get(i).getGonggaoren());
                            mtv.setText(ads.get(i).getGonggaoren());
                        }
                    }
                });
    }
}
