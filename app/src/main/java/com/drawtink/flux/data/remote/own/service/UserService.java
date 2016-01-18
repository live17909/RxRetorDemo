package com.drawtink.flux.data.remote.own.service;

import com.drawtink.flux.model.entity.User;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * <b>类名称：</b> UserService <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 下午6:59<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public interface UserService {

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("users/{id}")
    Observable<User> getUserById(@Path("id") int id);

    @FormUrlEncoded
    @PUT("users/{id}")
    Observable<String> updateUser(@Path("id") int id,
                                  @Field("name") String name,
                                  @Field("birthday") String birthday);

    @POST("users")
    Observable<String> createUser(@Body User user);

    @DELETE("users/{id}")
    Observable<String> deleteUser(@Path("id") int id);
}
