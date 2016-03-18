package com.yyf.mymedemo.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yyf.mymedemo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/3/18.
 */
public class MyRecyclerviewAdapter extends RecyclerView.Adapter<MyRecyclerviewAdapter.MyRecyclerViewHolder> {

    private Context context;
    private List<String> mDatas;

    public MyRecyclerviewAdapter(Context context,List<String> datas) {
        this.context = context;
        this.mDatas = datas;
    }

    @Override
    public MyRecyclerviewAdapter.MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyRecyclerViewHolder holder = new MyRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerviewAdapter.MyRecyclerViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    class  MyRecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.reitem);
        }
    }
}

