package com.project.budgetmanager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder> {
    List<> catalogList;
    OnCatalogClickListener catalogClickListener;


    public CatalogAdapter(List <>catalogList) {
        this.catalogList = catalogList;
    }


    public void setCatalogClickListener(OnCatalogClickListener catalogClickListener) {
        this.catalogClickListener = catalogClickListener;
    }

    @NonNull
    @Override
    public CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_row_view,null);
        return new CatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return catalogList.size();
    }

    class CatalogViewHolder extends RecyclerView.ViewHolder{
      ImageView image;
      TextView itemName,itemPrice;
        public CatalogViewHolder(@NonNull View itemView) {
            //Find the views from the view Layout
            super(itemView);
            image=itemView.findViewById(R.id.ivProductImage);
            itemName=itemView.findViewById(R.id.tvItemName);
            itemPrice=itemView.findViewById(R.id.tvInputPrice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (catalogClickListener!=null){
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                        catalogClickListener.onSingleClick(itemView,position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (catalogClickListener!=null){
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            catalogClickListener.onLongClick(itemView,position);
                        }
                        return true;
                    }else {
                    return false;
                    }
                }
            });

        }
    }
    interface OnCatalogClickListener{
        //Method if user clicks
        void onSingleClick(View view,int position);
        //Method if user longClicks
        void onLongClick(View view,int position);
    }
}
