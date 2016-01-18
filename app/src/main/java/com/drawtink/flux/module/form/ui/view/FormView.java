package com.drawtink.flux.module.form.ui.view;

/**
 * <b>类名称：</b> FormView <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月15日 下午1:51<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public interface FormView {
    void showProgress();

    void hideProgress();

    void saveSuccess();

    void saveError(String error);

}
