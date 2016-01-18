package com.drawtink.flux.module.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drawtink.flux.R;
import com.drawtink.flux.model.entity.User;
import com.drawtink.flux.module.list.adapter.viewholder.UserViewHolder;

import java.util.List;

/**
 * <b>类名称：</b> ListAdapter <br/>
 * <b>类描述：</b> <br/>
 * <b>创建人：</b> Lincoln <br/>
 * <b>修改人：</b> Lincoln <br/>
 * <b>修改时间：</b> 2016年01月14日 上午10:59<br/>
 * <b>修改备注：</b> <br/>
 *
 * @version 1.0.0 <br/>
 */
public class ListAdapter extends RecyclerView.Adapter<UserViewHolder>{

    private final Context mContext;
    private final List<User> data;
    private LayoutInflater inflater ;

    public ListAdapter(Context context , List<User> data){
        this.mContext = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_list_item,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = data.get(position);
        holder.id.setText(user.getId()+"");
        holder.name.setText(user.getName());
        holder.birthday.setText(user.getBirthday());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
