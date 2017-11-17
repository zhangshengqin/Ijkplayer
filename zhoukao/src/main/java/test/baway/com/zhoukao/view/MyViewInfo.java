package test.baway.com.zhoukao.view;

import java.util.List;

import test.baway.com.zhoukao.bean.MyBean;

/**
 * Created by 额头发 on 2017/11/6.
 */

public interface MyViewInfo {
    void showSuccess(List<MyBean.SongListBean> list);
    void failError(String msg);
}
