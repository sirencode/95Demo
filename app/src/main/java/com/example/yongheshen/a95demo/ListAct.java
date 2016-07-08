package com.example.yongheshen.a95demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yonghe.shen on 16/7/7.
 */
public class ListAct extends Activity implements HomeRecommendLivesAdapter.ItemClickInterface {
    private RecyclerView mRecyclerView;
    private HomeRecommendLivesAdapter mAdapter;
    private List<HomeRecommendLiveResult> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_recommed_live_list);
        initDatas();
        //得到控件
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        HomeRecommendLiveResult homeRecommendLiveResult = new HomeRecommendLiveResult();
        homeRecommendLiveResult.setLiveId(10);
        homeRecommendLiveResult.setLiveType("藏经阁");
        homeRecommendLiveResult.setLastRate(0.2525);
        homeRecommendLiveResult.setImgUrl("");
        homeRecommendLiveResult.setName("菜鸟"+10);
        mAdapter = new HomeRecommendLivesAdapter(this, homeRecommendLiveResult, mDatas);
        mAdapter.setItemClickInterface(this);
        mRecyclerView.setAdapter(mAdapter);

    }


    private void initDatas() {
        mDatas = new ArrayList<HomeRecommendLiveResult>();
        HomeRecommendLiveResult recommendResult = null;
        for (int i=0;i<10;i++){
            recommendResult = new HomeRecommendLiveResult();
            recommendResult.setLiveId(i);
            recommendResult.setLiveType("藏经阁");
            recommendResult.setLastRate(0.2525);
            recommendResult.setImgUrl("");
            recommendResult.setName("菜鸟"+i);
            mDatas.add(recommendResult);
        }
    }

    @Override
    public void headItemClick(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void normalItemClick(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
