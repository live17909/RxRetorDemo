package com.drawtink.flux.module.simple.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.drawtink.flux.R;
import com.drawtink.flux.model.entity.User;
import com.drawtink.flux.module.simple.component.DaggerSimpleComponent;
import com.drawtink.flux.module.simple.module.SimpleModule;
import com.drawtink.flux.module.simple.presenter.SimplePresenter;
import com.drawtink.flux.module.simple.ui.view.UserView;

import javax.inject.Inject;

/**
 * <b>类名称：</b> SimpleActivity <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 上午10:13<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class SimpleActivity extends AppCompatActivity implements UserView {

    ProgressDialog progressDialog;

    TextView id;
    TextView name;
    TextView birthday;

    @Inject
    SimplePresenter simplePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("请稍后");
        progressDialog.setMessage("正在加载用户数据");

        id = (TextView) findViewById(R.id.id);
        name = (TextView) findViewById(R.id.name);
        birthday = (TextView) findViewById(R.id.birthday);
        simplePresenter = DaggerSimpleComponent.builder()
                .simpleModule(new SimpleModule(this))
                .build()
                .presenter();
        simplePresenter.getUser(1);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void updateView(User user) {
        id.setText(user.getId()+"");
        name.setText(user.getName());
        birthday.setText(user.getBirthday());
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        Log.e("error",msg);
    }
}
