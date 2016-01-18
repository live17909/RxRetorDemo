package com.drawtink.flux.module.simple.module;

import com.drawtink.flux.module.simple.presenter.SimplePresenter;
import com.drawtink.flux.module.simple.presenter.impl.SimplePresenterImpl;
import com.drawtink.flux.module.simple.ui.view.UserView;

import dagger.Module;
import dagger.Provides;

/**
 * <b>类名称：</b> SimpleModule <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月18日 下午3:20<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
@Module
public class SimpleModule {

    private final UserView userView;

    public SimpleModule(UserView userView){
        this.userView = userView;
    }

    @Provides
    public UserView provideSimpleActivity(){
        return userView;
    }

    @Provides
    public SimplePresenter provideSimplePresenter(){
        return new SimplePresenterImpl(userView);
    }
}
