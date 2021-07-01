package com.synergy_project.ahomeproject.main.groupsFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.synergy_project.ahomeproject.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.MyViewHolder> {
    String[] group_users, group_timeStamp, group_postContent;
    Context ct;
    int[] images;

    public GroupsAdapter(Context ct, String[] group_users, String[] group_timeStamp, String[] group_postContent, int[] images) {
        this.ct = ct;
        this.group_users = group_users;
        this.group_timeStamp = group_timeStamp;
        this.group_postContent = group_postContent;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.rows_fragment_groups, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupsAdapter.MyViewHolder holder, int position) {
        holder.rows_name.setText(group_users[position]);
        holder.rows_timeStamp.setText(group_timeStamp[position]);
        holder.rows_postContent.setText(group_postContent[position]);
        holder.imgProfile_rowGroup.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return group_users.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView rows_name, rows_timeStamp, rows_postContent;
        CircleImageView imgProfile_rowGroup;
        ConstraintLayout mainLayout;

        public MyViewHolder(View view) {
            super(view);
            imgProfile_rowGroup = view.findViewById(R.id.imgProfile_rowGroup);
            rows_name = view.findViewById(R.id.rows_name);
            rows_timeStamp = view.findViewById(R.id.rows_timeStamp);
            rows_postContent = view.findViewById(R.id.rows_postContent);
            mainLayout = view.findViewById(R.id.mainLayout);
        }
    }
}
