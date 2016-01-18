package com.drawtink.flux.module.list.ui.view;

import com.drawtink.flux.model.entity.User;

import java.util.List;

/**
 * <b>类名称：</b> ListView <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 上午10:37<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public interface ListView {
    void showData(List<User> data);
    void showProgress();
    void hideProgress();
}
