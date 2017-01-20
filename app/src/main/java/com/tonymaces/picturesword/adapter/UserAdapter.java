package com.tonymaces.picturesword.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tonymaces.picturesword.R;
import com.tonymaces.picturesword.model.User;

import java.util.ArrayList;

/**
 * Created by Tony Macavilca Estrada on 13/08/2016.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private static final String TAG = UserAdapter.class.toString();
    private ArrayList<User> mUsers;
    private Context mContext;

    public UserAdapter(Context context) {
        this.mContext = context;
        this.mUsers = new ArrayList<>();
    }

    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_recent_media,parent,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserAdapter.UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.tvLikes.setText(String.valueOf(user.getLikes()) + "Likes");
      /*  Picasso.with(mContext)
            .load(user.getUrlImage())
            .placeholder(R.drawable.ic_account_box) // image the default
             .into(holder.imgPhoto);*/
    }

    public void SetUser(User user){
        Log.d(TAG,user.getFullName());
        mUsers.add(user);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLikes;
        private ImageView imgPhoto;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            imgPhoto = (ImageView) itemView.findViewById(R.id.imgPhoto);
        }
    }
}

