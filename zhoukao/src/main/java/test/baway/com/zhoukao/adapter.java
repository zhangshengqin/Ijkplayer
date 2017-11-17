package test.baway.com.zhoukao;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.baway.com.zhoukao.bean.MyBean;

/**
 * Created by 额头发 on 2017/11/6.
 */

public class adapter extends RecyclerView.Adapter {
    int visible = View.GONE;
    private MainActivity ss;
    Context context;

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    private MyViewHolder myViewHolder;
    List<MyBean.SongListBean> list;
    private View view;

    public adapter(List<MyBean.SongListBean> list,Context context) {
        this.list = list;
        this.context = context;
        ss = (MainActivity) context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        myViewHolder = (MyViewHolder) holder;
        MyBean.SongListBean listBean = list.get(position);
        myViewHolder.tv.setText(listBean.getTitle());
        Uri uri = Uri.parse(listBean.getPic_big());
        myViewHolder.sdv.setImageURI(uri);
        myViewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    list.get(position).setCheck(b);
                if (b){
                    ss.setQ(Qx());
                }else {
                    ss.setQ(false);
                }
            }

        });
        myViewHolder.cb.setChecked(list.get(position).isCheck());
        myViewHolder.cb.setVisibility(visible);
    }
    public boolean Qx(){
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isCheck()){
                return false;
            }
        }
        return true;
    }


    public void Qx1(){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCheck(true);
            notifyDataSetChanged();
        }

    }
    public void Qx2(){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCheck(false);
            notifyDataSetChanged();
        }

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private CheckBox cb;
        private SimpleDraweeView sdv;
        private TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb);
            sdv = itemView.findViewById(R.id.sdv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
