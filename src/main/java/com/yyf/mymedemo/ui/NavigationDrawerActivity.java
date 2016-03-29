package com.yyf.mymedemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.yyf.mymedemo.R;
import com.yyf.mymedemo.adpater.MyRecyclerviewAdapter;
import com.yyf.mymedemo.adpater.MyRecyclerviewHolder;
import com.yyf.mymedemo.model.Book;
import com.yyf.mymedemo.model.News;
import com.yyf.mymedemo.model.NewsResult;
import com.yyf.mymedemo.net.retrofit.NetWork;
import com.yyf.mymedemo.service.MDService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    private RecyclerView recyclerView;
    private SupportRecyclerView recyclerView;
    private List<NewsResult> mData;
    private MyRecyclerviewAdapter mAdapter;
    private String APPKEY="1e3d2cd47356e49c5148c791e6e72ba8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v,"ActionClick",Snackbar.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (SupportRecyclerView) findViewById(R.id.recyclerview);

        getData();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NavigationDrawerActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecycleViewDivider(
                NavigationDrawerActivity.this, LinearLayoutManager.VERTICAL));

       /* RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this,3);
        recyclerView.setLayoutManager(layoutManager);*/
        recyclerView.setHasFixedSize(true);


    }

    private void getData() {

        //https://api.douban.com/v2/book/1220562
      /*  Call<Book> call =NetWork.getRetrofit().create(MDService.class).loadBook();
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {

                RpSuccess(response);

            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Log.d("error","error:"+t);
            }
        });*/

        Call<News> call =NetWork.getRetrofit().create(MDService.class).loadNews("北京","json",APPKEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                RpSuccess(response);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d("error","error:"+t);
            }
        });

    }

    //请求成功
    private void RpSuccess(Response<News> response) {
        News news = response.body();
        Toast.makeText(NavigationDrawerActivity.this,news.getReason(),Toast.LENGTH_SHORT).show();
        mData = news.getResult();
        if(mData == null){
//            return;
            recyclerView.setEmptyView(findViewById(R.id.empty_view));
        }
        mAdapter = new MyRecyclerviewAdapter(NavigationDrawerActivity.this,mData){

            @Override
            public void onBindViewHolder(MyRecyclerviewHolder holder, int position) {
                bindData(holder, position, mData.get(position));
            }

            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.recyclerview_item;
            }

            @Override
            public void bindData(MyRecyclerviewHolder holder, int position, Object item) {
                if(item ==null){
                    return;
                }
                holder.setText(R.id.title,  ((NewsResult)item).getFull_title().toString());
                holder.setText(R.id.content, ((NewsResult)item).getContent().toString());
                holder.setImageView(R.id.image,((NewsResult)item).getImg().toString());
            }
        };
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MyRecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int pos) {
                Toast.makeText(NavigationDrawerActivity.this, "click " + pos, Toast.LENGTH_SHORT).show();
            }
        });

        mAdapter.setOnItemLongClickListener(new MyRecyclerviewAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View itemView, int pos) {
                Toast.makeText(NavigationDrawerActivity.this, "clickLONG " + pos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        if (id == R.id.action_collapsingtoolbarlayout) {
            Intent intent = new Intent(NavigationDrawerActivity.this,CollapsingtoolbarlayoutActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
