package test.baway.com.zhoukao.presenter;

import java.util.List;

import test.baway.com.zhoukao.bean.MyBean;
import test.baway.com.zhoukao.model.MyModel;
import test.baway.com.zhoukao.model.MyModelInfo;
import test.baway.com.zhoukao.model.OnClientListener;
import test.baway.com.zhoukao.view.MyViewInfo;

/**
 * Created by 额头发 on 2017/11/6.
 */

public class MyPresenter {
    MyViewInfo myViewInfo;
    MyModelInfo myModelInfo;

    public MyPresenter(MyViewInfo myViewInfo) {
        this.myViewInfo = myViewInfo;
        myModelInfo= new MyModel();
    }
    public void getSuccess(String url){
        myModelInfo.RequestSuccess(url, new OnClientListener() {
            @Override
            public void OnSuccess(List<MyBean.SongListBean> list) {
                myViewInfo.showSuccess(list);
            }

            @Override
            public void OnError(String url) {
                myViewInfo.failError(url);
            }
        });
    }
}
