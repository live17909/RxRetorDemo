package com.drawtink.flux.module.form.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.drawtink.flux.R;
import com.drawtink.flux.model.entity.User;
import com.drawtink.flux.module.form.present.FormPresenter;
import com.drawtink.flux.module.form.present.impl.FormPresenterImpl;
import com.drawtink.flux.module.form.ui.view.FormView;

import java.util.regex.Pattern;

/**
 * <b>类名称：</b> FormActivity <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月15日 上午11:26<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */


public class FormActivity extends AppCompatActivity implements FormView{

    EditText viewId;
    EditText viewName;
    EditText viewBirthday;
    Button viewButton;

    ProgressDialog progressDialog;

    FormPresenter formPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        formPresenter = new FormPresenterImpl(this);

        viewId = (EditText) findViewById(R.id.id);
        viewName = (EditText) findViewById(R.id.name);
        viewBirthday = (EditText) findViewById(R.id.birthday);
        viewButton = (Button) findViewById(R.id.submit);

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("请稍后");
        progressDialog.setMessage("正在保存用户数据");
    }

    private void submit() {
        String id = viewId.getText().toString();
        String name = viewName.getText().toString();
        String birthday = viewBirthday.getText().toString();

        boolean cancel = false;
        String errorMsg = "";
        if(TextUtils.isEmpty(id)){
            errorMsg ="id不能为空！";
            cancel = true;
        }else if(!Pattern.compile("[0-9]*").matcher(id).matches()){
            errorMsg = "id必须为数字！";
            cancel = true;
        }else if(TextUtils.isEmpty(name)){
            errorMsg = "name不能为空！";
            cancel = true;
        }else if(TextUtils.isEmpty(birthday)){
            errorMsg = "birthday不能为空！";
            cancel = true;
        }

        if(cancel){
            Toast.makeText(this,errorMsg,Toast.LENGTH_SHORT).show();
        }else {
            User user = new User();
            user.setId(Integer.parseInt(id));
            user.setName(name);
            user.setBirthday(birthday);
            formPresenter.saveUser(user);
        }
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
    public void saveSuccess() {
        Toast.makeText(this,"保存成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }
}
