package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.modelViewHolder> {
    List<model> list;
    Context context;
    public void setadp(List<model> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public  adapter(List<model> list,Context context) {
        this.list = list;
      this.context=context;
    }

    @NonNull
    @Override
    public adapter.modelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new modelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull modelViewHolder holder, int position) {
        model m=list.get(position);
        holder.name.setText(m.getName());
        holder.ngaygio.setText(m.getNgaygio());
        holder.ghichu.setText(m.getGhichu());
        holder.mau.setText(m.getColor());
        holder.cardView.setCardBackgroundColor(Integer.parseInt(m.getColor()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class modelViewHolder extends RecyclerView.ViewHolder {
        TextView name,ngaygio,ghichu,mau;
        CardView cardView;
        public modelViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.textView);
            ngaygio=(TextView) itemView.findViewById(R.id.textView2);
            ghichu=(TextView) itemView.findViewById(R.id.textView3);
            mau=(TextView) itemView.findViewById(R.id.textView4);
            cardView=itemView.findViewById(R.id.card);
        }
    }
}
