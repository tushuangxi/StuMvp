package com.config.pad.content.libding.widget.recyclerlist.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.config.pad.content.R;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Hello World .
 * Created by Matthew_Chen on 2018/3/15.
 */

public abstract class RecyclerViewBaseActivity<T> extends AppCompatActivity {

    /**
     * 页码，初始化为 1
     */
    private int currentPageIndex = 1;
    protected BaseQuickAdapter<T, BaseViewHolder> adapter;
    protected RecyclerView rv;
    protected SwipeRefreshLayout srl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recyclerview);

        initView();
    }

    private void initView() {

        rv = (RecyclerView) findViewById(R.id.rv);
        srl = (SwipeRefreshLayout) findViewById(R.id.srl);

        rv.setLayoutManager(getLayoutManager());
        rv.setAdapter(getAdapter());

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentPageIndex = 1;
                getData(currentPageIndex);
            }
        });

        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                currentPageIndex ++;
                getData(currentPageIndex);
            }
        }, rv);

        srl.setRefreshing(true);
        getData(currentPageIndex);
    }

    protected void handleError() {
        if (srl != null && adapter != null) {
            srl.setRefreshing(false);
            adapter.loadMoreComplete();
        }
    }

    protected void handleListData(List<T> listData, int page) {
        if (page == 1) {
            if (listData != null && listData.size() != 0) {
                adapter.setNewData(listData);
            } else {
                adapter.setNewData(new ArrayList<T>());
            }
            srl.setRefreshing(false);
        } else {
            if (listData != null && listData.size() != 0) {
                adapter.addData(listData);
            } else {
                adapter.setEnableLoadMore(false);
            }
            adapter.loadMoreComplete();
        }
    }

    protected abstract void initBeforeGetData();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract BaseQuickAdapter<T, BaseViewHolder> getAdapter();

    protected abstract void getData(int pageIndex);
}
