package test.baway.com.zhoukao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import test.baway.com.zhoukao.app.Api;
import test.baway.com.zhoukao.bean.MyBean;
import test.baway.com.zhoukao.presenter.MyPresenter;
import test.baway.com.zhoukao.view.MyViewInfo;

public class MainActivity extends AppCompatActivity implements MyViewInfo, View.OnClickListener {

    private RecyclerView rlv;
    private int i  = 0;
    private TextView bianji;
    private RelativeLayout rl;
    private adapter ap;
    private CheckBox cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv = (RecyclerView) findViewById(R.id.rlv);
        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.getSuccess(Api.PATH);
        initView();
    }

    private void initView() {
        bianji = (TextView) findViewById(R.id.tv2);
        bianji.setOnClickListener(this);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        rl = (RelativeLayout) findViewById(R.id.rl);
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb2.isChecked()){
                    ap.Qx1();
                }else {
                    ap.Qx2();
                }
            }
        });

    }


    @Override
    public void showSuccess(List<MyBean.SongListBean> list) {
        ap = new adapter(list,this);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        rlv.setAdapter(ap);
    }

    @Override
    public void failError(String msg) {

    }

    public void setQ(boolean bol){
        cb2.setChecked(bol);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv2:
                switch (i){
                    case 0:
                        rl.setVisibility(View.VISIBLE);
                        ap.setVisible(View.VISIBLE);
                        ap.notifyDataSetChanged();
                        bianji.setText("完成");
                        i = 1;
                        break;
                    case 1:
                        rl.setVisibility(View.GONE);
                        ap.setVisible(View.GONE);
                        ap.notifyDataSetChanged();
                        bianji.setText("编辑");
                        ap.Qx2();
                        i = 0;
                        break;
                }
                break;
        }
    }
}
