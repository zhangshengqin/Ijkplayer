package test.baway.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import test.baway.com.mvp.bean.MyBean;
import test.baway.com.mvp.presenter.MyPresenter;
import test.baway.com.mvp.view.ViewInfo;

public class MainActivity extends AppCompatActivity implements ViewInfo{

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.getDate("http://api.expoon.com/AppNews/getNewsList/type/1/p/1");

    }

    @Override
    public void showBean(MyBean myBean) {
        tv.setText(myBean.getData().get(0).getNews_title());
    }



}
