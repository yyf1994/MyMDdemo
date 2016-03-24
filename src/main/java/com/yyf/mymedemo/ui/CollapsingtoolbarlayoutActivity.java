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
import com.yyf.mymedemo.model.UserInfo;
import com.yyf.mymedemo.net.retrofit.NetWork;
import com.yyf.mymedemo.service.MDService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollapsingtoolbarlayoutActivity extends AppCompatActivity {

   private  TextView tv;

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

        Call<UserInfo> call = NetWork.getRetrofit().create(MDService.class).loadUserInfo("ahbei");
               call .enqueue(new Callback <UserInfo>() {

                    @Override
                    public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                        tv.setText(response.body().getTitle());
                    }

                    @Override
                    public void onFailure(Call<UserInfo> call, Throwable t) {
                        Toast.makeText(CollapsingtoolbarlayoutActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
