package com.yyf.mymedemo.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yyf.mymedemo.R;
import com.yyf.mymedemo.model.Book;
import com.yyf.mymedemo.model.News;
import com.yyf.mymedemo.model.NewsResult;
import com.yyf.mymedemo.model.UserInfo;
import com.yyf.mymedemo.net.retrofit.NetWork;
import com.yyf.mymedemo.service.MDService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollapsingtoolbarlayoutActivity extends AppCompatActivity {

   private  TextView tv;
    private String APPKEY="1e3d2cd47356e49c5148c791e6e72ba8";
    private List<NewsResult> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbarlayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tv = (TextView) findViewById(R.id.tv_userinfo);

        getData();
    }

    private void getData() {

        Call<News> call = NetWork.getRetrofit().create(MDService.class).loadNewsPost("北京","json",APPKEY);
               call .enqueue(new Callback <News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        News news = response.body();
                        mData = news.getResult();
                        if(mData == null){
                            return;
                        }
                        for(int i = 0;i<mData.size();i++){
                            tv.setText(mData.get(i).getTitle());
                        }

                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        Toast.makeText(CollapsingtoolbarlayoutActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
