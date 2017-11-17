package test.baway.com.a2.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.baway.com.a2.MainAdapter;
import test.baway.com.a2.MyFragment;
import test.baway.com.a2.R;

public class FourFragment extends Fragment {

    private View view;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private List<Fragment> fragments = new ArrayList<>();
    private MainAdapter mainAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_four_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tablayout = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);
        initView();
    }

    private void initView() {
        mainAdapter = new MainAdapter(getFragmentManager());
        fragments.add(MyFragment.newInstance("第一个fragment"));
        fragments.add(MyFragment.newInstance("第二个fragment"));
        fragments.add(MyFragment.newInstance("第三个fragment"));
        mainAdapter.setFragments(fragments);
        viewpager.setAdapter(mainAdapter);
        tablayout.setupWithViewPager(viewpager);


    }
}
