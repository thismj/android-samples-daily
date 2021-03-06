package io.github.thismj.android.main;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import io.github.thismj.android.BasicActivity;
import io.github.thismj.android.R;

public class MainActivity extends BasicActivity implements MainAdapter.OnItemClickListener {
    private static final String TAG = "MainActivity";

    private RecyclerView mRcvList;
    private MainAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public int getContent() {
        return R.layout.content_main;
    }

    @Override
    public void initComponent(View view) {
        initRcvList();
    }

    private void initRcvList() {
        mRcvList = findViewById(R.id.rcv_list);
        mAdapter = new MainAdapter(this);
        mAdapter.setOnItemClickListener(this);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRcvList.setAdapter(mAdapter);
        mRcvList.setLayoutManager(mLayoutManager);
        mRcvList.addItemDecoration(new MainDecoration());
    }

    @Override
    public void onItemClick(View view, int position, MainEntity entity) {
        startActivity(new Intent(this, entity.destination));
    }
}
