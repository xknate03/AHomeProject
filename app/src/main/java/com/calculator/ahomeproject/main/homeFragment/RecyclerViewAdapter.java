package com.calculator.ahomeproject.main.homeFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calculator.ahomeproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Book> mData;
    public RecyclerViewAdapter(Context context, List<Book> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.cardview_item_book, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        holder.txtBookTitle.setText(mData.get(position).getTitle());
        holder.imgBook_cardView.setImageResource(mData.get(position).getThumbnail());

        //Set Click Listener here
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtBookTitle;
        ImageView imgBook_cardView;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtBookTitle = (TextView) itemView.findViewById(R.id.txtBookTitle_cardView);
            imgBook_cardView = (ImageView) itemView.findViewById(R.id.imgBook_cardView);
        }
    }
}
