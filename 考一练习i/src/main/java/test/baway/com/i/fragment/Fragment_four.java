package test.baway.com.i.fragment;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;



import java.util.ArrayList;
import java.util.List;

import test.baway.com.i.MainAdapter;
import test.baway.com.i.MyFragment;
import test.baway.com.i.R;

public class Fragment_four extends Fragment {
    private List<Fragment> fragments = new ArrayList<>();
    private View view;

    private ViewPager vp;
    private PagerAdapter mainAdapter;
    private TabLayout tablayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_fragment_four, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tablayout = view.findViewById(R.id.tablayout);
        vp = view.findViewById(R.id.vp);
        initview();

    }

    private void initview() {
        MainAdapter mainAdapter = new MainAdapter(getFragmentManager());
        fragments.add(MyFragment.newInstance("第一个fragment"));
        fragments.add(MyFragment.newInstance("第二个fragment"));
        fragments.add(MyFragment.newInstance("第三个fragment"));
        mainAdapter.setFragments(fragments);
        vp.setAdapter(mainAdapter);

        //设置tabLayout
        tablayout.setupWithViewPager(vp);


    }


}
