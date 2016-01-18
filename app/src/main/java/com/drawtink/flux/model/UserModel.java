package com.drawtink.flux.model;

import com.drawtink.flux.model.entity.User;

import java.util.List;

import rx.Observable;

/**
 * <b>类名称：</b> UserModel <br/>
 * <b>类描述：</b> 用户数据获取接口<br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月13日 下午4:55<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public interface UserModel {
    /**
     * 获取指定id用户信息
     * @param id 用户id
     * @return
     */
    Observable<User> getUser(int id);

    Observable<List<User>> getUsers();

    Observable<String> saveUser(User user);
}
