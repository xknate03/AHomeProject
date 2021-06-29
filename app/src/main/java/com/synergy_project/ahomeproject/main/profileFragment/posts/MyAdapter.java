package com.synergy_project.ahomeproject.main.profileFragment.posts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.synergy_project.ahomeproject.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String[] name, timeStamp, postContent;
    Context ct;
    int[] images;

    public MyAdapter(Context ct, String[] name, String[] timeStamp, String[] postContent) {
        this.ct = ct;
        this.name = name;
        this.timeStamp = timeStamp;
        this.postContent = postContent;
    }


    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.rows, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.rows_name.setText(name[position]);

        holder.rows_timeStamp.setText(timeStamp[position]);
        holder.rows_postContent.setText(postContent[position]);


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ct, Content.class);
                intent.putExtra("name", name[position]);
                intent.putExtra("timeStamp", timeStamp[position]);
                intent.putExtra("postContent", postContent[position]);

                ct.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView rows_name, rows_timeStamp, rows_postContent;
//        ImageView imgImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(View view) {
            super(view);

            rows_name = view.findViewById(R.id.rows_name);
            rows_timeStamp = view.findViewById(R.id.rows_timeStamp);
            rows_postContent = view.findViewById(R.id.rows_postContent);
            mainLayout = view.findViewById(R.id.mainLayout);


        }
    }
}
