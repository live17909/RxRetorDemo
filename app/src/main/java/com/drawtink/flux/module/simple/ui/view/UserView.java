package com.drawtink.flux.module.simple.ui.view;

import com.drawtink.flux.model.entity.User;

/**
 * <b>类名称：</b> UserView <br/>
 * <b>类描述：</b> User界面接口<br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月13日 下午5:59<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public interface UserView {
    void showProgress();

    void hideProgress();

    void updateView(User user);

    void showError(String msg);

}
