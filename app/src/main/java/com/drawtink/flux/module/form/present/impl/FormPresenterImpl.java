package com.drawtink.flux.module.form.present.impl;

import com.drawtink.flux.model.UserModel;
import com.drawtink.flux.model.entity.User;
import com.drawtink.flux.model.impl.UserModelImpl;
import com.drawtink.flux.module.form.present.FormPresenter;
import com.drawtink.flux.module.form.ui.view.FormView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <b>类名称：</b> FormPresenterImpl <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 上午9:57<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class FormPresenterImpl implements FormPresenter {

    private FormView formView;

    private UserModel model;

    public FormPresenterImpl(FormView formView)
    {
        this.formView = formView;
        model= new UserModelImpl();
    }

    @Override
    public void saveUser(User user) {
            formView.showProgress();
            model.saveUser(user)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<String>() {
                        @Override
                        public void onCompleted() {
                            formView.hideProgress();
                            formView.saveSuccess();
                        }

                        @Override
                        public void onError(Throwable e) {
                            formView.hideProgress();
                            formView.saveError(e.getMessage());
                        }

                        @Override
                        public void onNext(String s) {
                        }
                    });
    }


}
