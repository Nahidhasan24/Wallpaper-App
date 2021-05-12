package com.nahidstudio.pixelapiwallpaper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nahidstudio.pixelapiwallpaper.Activitys.FullActivity;
import com.nahidstudio.pixelapiwallpaper.Models.Responcce;
import com.nahidstudio.pixelapiwallpaper.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    private Context context;
    private List<Responcce> mainResponceList;

    public MainAdapter(Context context, List<Responcce> mainResponceList) {
        this.context = context;
        this.mainResponceList = mainResponceList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_lis,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        Picasso.get().load(mainResponceList.get(position).getSrc().getMedium())
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, FullActivity.class)
                .putExtra("Image",mainResponceList.get(position).getSrc().getOriginal()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainResponceList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView  imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ImageView);
        }
    }
}
