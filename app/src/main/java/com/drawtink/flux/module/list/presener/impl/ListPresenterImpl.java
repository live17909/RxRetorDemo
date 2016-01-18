package com.drawtink.flux.module.list.presener.impl;

import com.drawtink.flux.model.UserModel;
import com.drawtink.flux.model.entity.User;
import com.drawtink.flux.model.impl.UserModelImpl;
import com.drawtink.flux.module.list.presener.ListPresenter;
import com.drawtink.flux.module.list.ui.view.ListView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <b>类名称：</b> ListPresenterImpl <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月15日 下午2:13<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class ListPresenterImpl implements ListPresenter {

    private final ListView listView;
    private UserModel model ;

    public ListPresenterImpl(ListView listView){
        this.listView = listView;
        model = new UserModelImpl();
    }

    @Override
    public void getUsers() {
        listView.showProgress();
        model.getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {
                        listView.hideProgress();
                        unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("ListPresenterImpl.onError--->"+e.getMessage());
                        listView.hideProgress();
                        unsubscribe();
                    }

                    @Override
                    public void onNext(List<User> users) {
                        listView.showData(users);
                    }
                });
    }
}
