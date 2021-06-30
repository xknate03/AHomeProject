package com.synergy_project.ahomeproject.main.homeFragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.synergy_project.ahomeproject.R;

import org.jetbrains.annotations.NotNull;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    String[] petName, petType, description, petLocation;
    int[] petImage;
    String[] petSex, petStatus, petAge, petColor;

    public RecyclerViewAdapter(Context context, String[] petName, String[] petType, String[] description,
                               int[] petImage, String[] petSex, String[] petStatus, String[] petAge,
                               String[] petColor,String[] petLocation) {
        mContext = context;
        this.petName = petName;
        this.petImage = petImage;
        this.petType = petType;
        this.description = description;
        this.petSex = petSex;
        this.petStatus = petStatus;
        this.petAge = petAge;
        this.petColor = petColor;
        this.petLocation = petLocation;
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
        holder.petName.setText(petName[position]);
        holder.petImage.setImageResource(petImage[position]);
        //Set Click Listener here
        holder.mainLayout_cardView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, PetInformation.class);
            intent.putExtra("petName", petName[position]);
            intent.putExtra("petImage", petImage[position]);
            intent.putExtra("petType", petType[position]);
            intent.putExtra("petSex", petSex[position]);
            intent.putExtra("petStatus", petStatus[position]);
            intent.putExtra("petAge", petAge[position]);
            intent.putExtra("petColor", petColor[position]);
            intent.putExtra("petLocation", petLocation[position]);
            intent.putExtra("description", description[position]);


            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return petName.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView petName;
        ImageView petImage;
        CardView mainLayout_cardView;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            petName = itemView.findViewById(R.id.txtPetName_cardView);
            petImage = itemView.findViewById(R.id.imgPetImage);
            mainLayout_cardView = itemView.findViewById(R.id.mainLayout_cardView);
        }
    }
}
