package com.drawtink.flux.module.list.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.drawtink.flux.R;

/**
 * <b>类名称：</b> UserViewHolder <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 上午11:05<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView id;
    public TextView name;
    public TextView birthday;
    public UserViewHolder(View itemView) {
        super(itemView);
        id = (TextView) itemView.findViewById(R.id.id);
        name = (TextView) itemView.findViewById(R.id.name);
        birthday = (TextView) itemView.findViewById(R.id.birthday);
    }



}
