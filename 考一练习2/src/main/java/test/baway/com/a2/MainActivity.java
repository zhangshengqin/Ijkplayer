package test.baway.com.a2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjm.bottomtabbar.BottomTabBar;

import test.baway.com.a2.fragment.FiveFragment;
import test.baway.com.a2.fragment.FourFragment;
import test.baway.com.a2.fragment.OneFragment;
import test.baway.com.a2.fragment.ThreeFragment;
import test.baway.com.a2.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar bottom_tab_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_tab_bar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        bottom_tab_bar.init(getSupportFragmentManager())
                .addTabItem("新闻",R.mipmap.ic_launcher, OneFragment.class)
                .addTabItem("新闻",R.mipmap.ic_launcher, TwoFragment.class)
                .addTabItem("新闻",R.mipmap.ic_launcher, ThreeFragment.class)
                .addTabItem("新闻",R.mipmap.ic_launcher, FourFragment.class)
                .addTabItem("新闻",R.mipmap.ic_launcher, FiveFragment.class);

    }
}
