package com.drawtink.flux.data.remote.own;

/**
 * <b>类名称：</b> RequestPath <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 下午4:33<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public final class RemoteAddress {
    private static final String IP_ADDRESS = "http://192.168.0.46";
    private static final String PORT = ":8080";
    private static final String PROJECT_NAME ="/";

    public static String getRequestPath(){
        return IP_ADDRESS + PORT + PROJECT_NAME;
    }
}
