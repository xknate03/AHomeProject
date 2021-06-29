package com.synergy_project.ahomeproject.main.notifsFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.synergy_project.ahomeproject.R;

import org.jetbrains.annotations.NotNull;

public class NotifListAdapter extends RecyclerView.Adapter<NotifListAdapter.MyViewHolder> {

    String [] notif, time;
    int[] img;

    public NotifListAdapter(String[] notif, String [] time, int[]img){
        this.notif = notif;
        this.time = time;
        this.img = img;

    }


    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notif_list_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.textView1.setText(notif[position]);
        holder.textView2.setText(time[position]);
        holder.imageView.setImageResource(img[position]);


    }

    @Override
    public int getItemCount() {
        return notif.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView1, textView2;
        ImageView imageView;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.notifText);
            textView2 = itemView.findViewById(R.id.timeText);
            imageView = itemView.findViewById(R.id.notifImg);

        }
    }
}
