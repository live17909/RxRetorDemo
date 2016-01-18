package com.drawtink.flux.model.impl;

import com.drawtink.flux.data.remote.RetrofitHelper;
import com.drawtink.flux.data.remote.own.RemoteAddress;
import com.drawtink.flux.data.remote.own.service.UserService;
import com.drawtink.flux.model.UserModel;
import com.drawtink.flux.model.entity.User;

import java.util.List;

import retrofit2.JacksonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * <b>类名称：</b> UserModelImpl <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月13日 下午5:02<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class UserModelImpl extends RetrofitHelper<UserService> implements UserModel{
    UserService userService;

    public UserModelImpl(){
        userService = getRetrofit(UserService.class);
    }

    @Override
    public Observable<User> getUser(int id) {
        return userService.getUserById(id);
//                Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//
//                String json ="{\n" +
//                        "    \"id\": 1,\n" +
//                        "    \"name\": \"林肯\",\n" +
//                        "    \"birthDay\": \"1991-02-28\"\n" +
//                        "}";
//                if (TextUtils.isEmpty(json)){
//                    subscriber.onError(new Throwable("数据获取失败！"));
//                }else{
//                    subscriber.onNext(json);
//                    subscriber.onCompleted();
//                }
//            }
//        }).map(new Func1<String, User>() {
//            @Override
//            public User call(String s) {
//                try {
//                    JSONObject obj = new JSONObject(s);
//                    User user = new User();
//                    user.setId(obj.getInt("id"));
//                    user.setName(obj.getString("name"));
//                    user.setBirthDay(obj.getString("birthDay"));
//                    System.out.println("UserModelImpl.call-->"+Thread.currentThread().getName());
//                    return user;
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                return null;
//            }
//        });
//        return Observable.just("http://www.baidu.com").map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                return "{\n" +
//                        "  \"code\": \"ok\",\n" +
//                        "  \"msg\": \"\",\n" +
//                        "  \"data\": {\n" +
//                        "    \"id\": 1,\n" +
//                        "    \"name\": \"林肯\",\n" +
//                        "    \"birthDay\": \"1991-02-28\"\n" +
//                        "  }\n" +
//                        "}";
//            }
//        }).map(new Func1<String, User>() {
//            @Override
//            public User call(String s) {
//                try {
//                    JSONObject obj = new JSONObject(s);
//                    User user = new User();
//                    user.setId(obj.getInt("id"));
//                    user.setName(obj.getString("name"));
//                    user.setBirthDay(obj.getString("birthDay"));
//                    return user;
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                return null;
//            }
//        });


    }

    @Override
    public Observable<List<User>> getUsers() {
        return userService.getUsers();

//        Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                String json ="[" +
//                        "{\n" +
//                        "    \"id\": 1,\n" +
//                        "    \"name\": \"林肯\",\n" +
//                        "    \"birthDay\": \"199X-XX-XX\"\n" +
//                        "}," +
//                        "{\n" +
//                        "    \"id\": 2,\n" +
//                        "    \"name\": \"王仝\",\n" +
//                        "    \"birthDay\": \"199X-XX-XX\"\n" +
//                        "}" +
//                        "]";
//                subscriber.onNext(json);
//                subscriber.onCompleted();
//            }
//        }).map(new Func1<String, List<User>>() {
//            @Override
//            public List<User> call(String s) {
//                System.out.println("UserModelImpl.call");
//                return JSONArray.parseArray(s,User.class);
//            }
//        });
    }

    @Override
    public Observable<String> saveUser(User user) {
        return getRetrofit(UserService.class).updateUser(user.getId(),
                user.getName(),
                user.getBirthday());
    }

    @Override
    public Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(RemoteAddress.getRequestPath())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(writeLogClient())
                .build();
    }
}
