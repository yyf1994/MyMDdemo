package com.yyf.mymedemo.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/18.
 */
public abstract class MyRecyclerviewAdapter<T> extends RecyclerView.Adapter<MyRecyclerviewHolder> {

    private Context context;
    private List<T> mDatas;
    protected LayoutInflater mInflater;
    private OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;

    public MyRecyclerviewAdapter(Context ctx,List<T> datas) {
        mDatas = (datas != null) ? datas : new ArrayList<T>();
        context = ctx;
        mInflater = LayoutInflater.from(ctx);
    }


    @Override
    public MyRecyclerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final MyRecyclerviewHolder holder = new MyRecyclerviewHolder(context, mInflater.inflate(getItemLayoutId(viewType), parent, false));
        if (mClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
    }
    if (mLongClickListener != null) {
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                return true;
            }
        });
    }

    return holder;
}

    @Override
    public void onBindViewHolder(MyRecyclerviewHolder holder, int position) {
        bindData(holder, position, mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void add(int pos, T item) {
        mDatas.add(pos, item);
        notifyItemInserted(pos);
    }

    public void delete(int pos) {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

        mClickListener = listener;

    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {

        mLongClickListener = listener;

    }

    abstract public int getItemLayoutId(int viewType);

    abstract public void bindData(MyRecyclerviewHolder holder, int position, T item);

    public interface OnItemClickListener {

        public void onItemClick(View itemView, int pos);

    }

    public interface OnItemLongClickListener {

     public void onItemLongClick(View itemView, int pos);

}

}

