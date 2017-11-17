package test.baway.com.i;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import test.baway.com.i.fragment.Fragment_five;
import test.baway.com.i.fragment.Fragment_four;
import test.baway.com.i.fragment.Fragment_one;
import test.baway.com.i.fragment.Fragment_three;
import test.baway.com.i.fragment.Fragment_two;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottom_tab_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_tab_bar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        bottom_tab_bar.init(getSupportFragmentManager())
                .addTabItem("首页",R.mipmap.ic_launcher, Fragment_one.class)
                .addTabItem("自选",R.mipmap.ic_launcher, Fragment_two.class)
                .addTabItem("行情",R.mipmap.ic_launcher, Fragment_three.class)
                .addTabItem("资讯",R.mipmap.ic_launcher, Fragment_four.class)
                .addTabItem("交易",R.mipmap.ic_launcher, Fragment_five.class);

    }
}
