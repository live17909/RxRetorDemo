package com.drawtink.flux.module.list.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.drawtink.flux.R;
import com.drawtink.flux.model.entity.User;
import com.drawtink.flux.module.list.presener.ListPresenter;
import com.drawtink.flux.module.list.presener.impl.ListPresenterImpl;
import com.drawtink.flux.module.list.adapter.ListAdapter;
import com.drawtink.flux.module.list.ui.view.ListView;

import java.util.List;

/**
 * <b>类名称：</b> ListActivity <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 上午10:20<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class ListActivity extends AppCompatActivity implements ListView{

    RecyclerView list;

    ProgressDialog progressDialog;

    ListPresenter listPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("请稍后");
        progressDialog.setMessage("正在加载列表数据，请稍后……");

        listPresenter = new ListPresenterImpl(this);
        listPresenter.getUsers();
    }

    @Override
    public void showData(List<User> data) {
        ListAdapter adapter = new ListAdapter(this,data);
        list.setAdapter(adapter);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }
}
