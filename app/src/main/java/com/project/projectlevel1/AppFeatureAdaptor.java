package com.project.projectlevel1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AppFeatureAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List <AppFeature>appFeatures;

    public AppFeatureAdaptor(Context context, List <AppFeature>AppFeature){
        this.context = context;
        this.appFeatures = AppFeature;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.feature_item,parent,false);
        return new  AppFeatureHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
if(holder instanceof AppFeatureHolderView){


AppFeatureHolderView holderView=(AppFeatureHolderView)holder;
((AppFeatureHolderView) holder).binAppFeatur(appFeatures.get(position));
}

    }

    @Override
    public int getItemCount() {
        return appFeatures.size();
    }



}

class AppFeatureHolderView extends RecyclerView.ViewHolder {
    TextView textView=(TextView) itemView.findViewById(R.id.feature_title);
    ImageView Imageview=(ImageView) itemView.findViewById(R.id.feature_image_view);
    public AppFeatureHolderView(@NonNull View itemView) {
        super(itemView);

    }



    public void binAppFeatur(final AppFeature appFeature){
        Picasso.with(itemView.getContext()).load(appFeature.getFeatureImage()).into(Imageview);
        textView.setText(appFeature.getTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(),
                        appFeature.getDestinationActivity()));


            }
        });
    }
}
