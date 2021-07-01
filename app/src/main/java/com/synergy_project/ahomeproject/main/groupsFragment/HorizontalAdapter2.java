package com.synergy_project.ahomeproject.main.groupsFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.synergy_project.ahomeproject.R;

public class HorizontalAdapter2 extends RecyclerView.Adapter<HorizontalAdapter2.MyViewHolder> {
    String[] group_myGroup;
    Context ct;
    int[] images;

    public HorizontalAdapter2(Context ct, String[] group_myGroup, int[] images) {
        this.group_myGroup = group_myGroup;
        this.ct = ct;
        this.images = images;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.rows_fragment_mygroups, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapter2.MyViewHolder holder, int position) {
        holder.imgGroupImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return group_myGroup.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgGroupImage;
//        ImageView imgImage;
        ConstraintLayout mainLayout_horizontal;

        public MyViewHolder(View view) {
            super(view);
            imgGroupImage = view.findViewById(R.id.imgGroupImage);

            mainLayout_horizontal = view.findViewById(R.id.mainLayout_horizontal);


        }
    }
}
