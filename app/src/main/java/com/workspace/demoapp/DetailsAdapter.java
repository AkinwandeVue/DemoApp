package com.workspace.demoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {

    private Context cmtx;
    private List<Details> detailsList;

    public DetailsAdapter(Context cmtx, List<Details> detailsList) {
        this.cmtx = cmtx;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailsViewHolder(
                LayoutInflater.from(cmtx).inflate(R.layout.layout_detail, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        Details details = detailsList.get(position);

        holder.textViewName.setText(details.getName());
        holder.textViewPhone.setText( "Available Contact " + details.getPhone());
        holder.textViewAccount.setText(details.getAccount());
        holder.textViewAmount.setText("$" + details.getAmount());
        holder.textViewTrans.setText(details.getTransaction());
        holder.textViewDate.setText("Last Day "+ details.getDate());
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    class DetailsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName, textViewPhone, textViewAccount, textViewAmount, textViewTrans, textViewDate;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
            textViewAccount = itemView.findViewById(R.id.textViewAccoount);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            textViewTrans = itemView.findViewById(R.id.textViewTrans);
            textViewDate = itemView.findViewById(R.id.textViewDate);

        }
    }
}
