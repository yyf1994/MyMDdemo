package com.yyf.mymedemo.ui;

import android.app.PendingIntent;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.List;

/**
 * Created by starkshang on 2015/10/29.
 */
public class SupportRecyclerView extends RecyclerView {
    private View emptyView;
//    private OnRecyclerViewItemClickListener mOnItemClickListener;
//    private OnRecyclerViewItemLongClickListener mOnItemLongClickListener;

    private AdapterDataObserver emptyObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            Log.e("smy","adapter changed");
            Adapter adapter =  getAdapter();
            if(adapter != null && emptyView != null) {
                if(adapter.getItemCount() == 0) {
                    Log.e("smy","adapter visible");
                    emptyView.setVisibility(View.VISIBLE);
                    SupportRecyclerView.this.setVisibility(View.GONE);
                } else {
                    Log.e("smy","adapter gone");
                    emptyView.setVisibility(View.GONE);
                    SupportRecyclerView.this.setVisibility(View.VISIBLE);
                }
            }

        }
    };

    public SupportRecyclerView(Context context) {
        super(context);
    }

    public SupportRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SupportRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAdapter(Adapter adapter) {
        Adapter oldAdapter = getAdapter();
        if(oldAdapter != null && emptyObserver != null){
            oldAdapter.unregisterAdapterDataObserver(emptyObserver);
        }
        super.setAdapter(adapter);

        if(adapter != null) {
            adapter.registerAdapterDataObserver(emptyObserver);
        }
        emptyObserver.onChanged();
    }

    /**
     * set view when no content item
     * @param emptyView  visiable view when items is empty
     */
    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }


}
