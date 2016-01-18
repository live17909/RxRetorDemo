package com.drawtink.flux.module.simple.presenter.impl;

import com.drawtink.flux.model.UserModel;
import com.drawtink.flux.model.entity.User;
import com.drawtink.flux.model.impl.UserModelImpl;
import com.drawtink.flux.module.simple.presenter.SimplePresenter;
import com.drawtink.flux.module.simple.ui.view.UserView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <b>类名称：</b> SimplePresenterImpl <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月15日 下午2:11<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class SimplePresenterImpl implements SimplePresenter {

    UserView userView;
    private UserModel model;

    public SimplePresenterImpl(UserView userView){
        this.userView = userView;
        model = new UserModelImpl();
    }

    @Override
    public void getUser( int id) {
        userView.showProgress();
        model.getUser(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {
                        userView.hideProgress();
                        unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        userView.showError(e.getLocalizedMessage());
                        userView.hideProgress();
                        unsubscribe();
                    }

                    @Override
                    public void onNext(User user) {
                        userView.updateView(user);
                    }
                });
    }
}
