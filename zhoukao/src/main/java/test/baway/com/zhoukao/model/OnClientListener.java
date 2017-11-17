package test.baway.com.zhoukao.model;

import java.util.List;

import test.baway.com.zhoukao.bean.MyBean;

/**
 * Created by 额头发 on 2017/11/6.
 */

public interface OnClientListener {
    void OnSuccess(List<MyBean.SongListBean> list);
    void OnError(String url);
}
