package com.drawtink.flux.module.simple.component;

import com.drawtink.flux.module.simple.module.SimpleModule;
import com.drawtink.flux.module.simple.presenter.SimplePresenter;
import com.drawtink.flux.module.simple.ui.view.UserView;

import dagger.Component;

/**
 * <b>类名称：</b> SimpleComponent <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月18日 下午3:23<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
@Component(modules = SimpleModule.class)
public interface SimpleComponent {

    UserView userView();

    SimplePresenter presenter();

}
