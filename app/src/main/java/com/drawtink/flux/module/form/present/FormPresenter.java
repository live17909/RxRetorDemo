package com.drawtink.flux.module.form.present;

import com.drawtink.flux.model.entity.User;

import dagger.Component;

/**
 * <b>类名称：</b> UserPresenter <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 上午8:44<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public interface FormPresenter {

    void saveUser(User user);

}
