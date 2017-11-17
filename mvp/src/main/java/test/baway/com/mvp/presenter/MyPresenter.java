package test.baway.com.mvp.presenter;

import com.google.gson.Gson;

import test.baway.com.mvp.bean.MyBean;
import test.baway.com.mvp.model.ModelInfo;
import test.baway.com.mvp.model.MyModel;
import test.baway.com.mvp.view.ViewInfo;

/**
 * Created by 额头发 on 2017/11/5.
 */

public class MyPresenter {
    ViewInfo viewInfo;
    private final MyModel myModel;

    public MyPresenter(ViewInfo viewInfo) {
        this.viewInfo = viewInfo;
        myModel = new MyModel();
    }
    public void getDate(String url){
            myModel.doGet(url, new ModelInfo() {
                @Override
                public void showSuccess(String msg) {
                    Gson gson = new Gson();
                    MyBean myBean = gson.fromJson(msg, MyBean.class);
                    viewInfo.showBean(myBean);
                }

                @Override
                public void failError(String msg) {

                }
            });
    }
}
