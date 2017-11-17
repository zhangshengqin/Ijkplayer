package test.baway.com.zhoukao.app;

import retrofit2.http.GET;
import rx.Observable;
import test.baway.com.zhoukao.bean.MyBean;

/**
 * Created by 额头发 on 2017/11/6.
 */

public interface ApiService {
    @GET("v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=5&offset=0")
    Observable<MyBean> getDate();
}
