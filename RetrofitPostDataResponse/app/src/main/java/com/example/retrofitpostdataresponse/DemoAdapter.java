package com.example.retrofitpostdataresponse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder>{

    private List<Datum> datumList;

    public DemoAdapter(List<Datum> datumList) {
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.catname.setText(datumList.get(position).getCatName());
        holder.status.setText(datumList.get(position).getStatus());
        holder.createdate.setText(datumList.get(position).getCreateDate());
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView catname,status,createdate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catname=itemView.findViewById(R.id.catname);
            status=itemView.findViewById(R.id.status);
            createdate=itemView.findViewById(R.id.createdate);
        }
    }
}
