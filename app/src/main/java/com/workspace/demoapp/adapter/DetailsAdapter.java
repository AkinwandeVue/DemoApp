package com.workspace.demoapp.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.workspace.demoapp.R;
import com.workspace.demoapp.data.model.AccountDetails;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsAdapter extends FirestoreAdapter<DetailsAdapter.DetailsViewHolder> {

    private Context context;
    private Query mQuery;

    public interface OnAccountDetailSelectedListener {
        void onAccountDetailsSelected(DocumentSnapshot restaurant);

    }

    private OnAccountDetailSelectedListener mListener;

    public DetailsAdapter(Query query ,OnAccountDetailSelectedListener listener) {
        super(query);
        mListener = listener;
    }


    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new DetailsViewHolder(inflater.inflate(R.layout.layout_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder detailsViewHolder, int position) {
        detailsViewHolder.bind(getSnapshot(position), mListener);
    }


   public static class DetailsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewName)
        TextView name;

        @BindView(R.id.textViewPhone)
        TextView phone;

        @BindView(R.id.textViewAccoount)
        TextView account;

        @BindView(R.id.textViewAmount)
        TextView amount;

        @BindView(R.id.textViewTrans)
        TextView trans;

        @BindView(R.id.textViewDate)
        TextView date;

        public DetailsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final DocumentSnapshot snapshot,
                         final OnAccountDetailSelectedListener listener) {

            AccountDetails accountDetails = snapshot.toObject(AccountDetails.class);
            Resources resources = itemView.getResources();

            name.setText(accountDetails.getName());
            phone.setText(accountDetails.getPhone());
            account.setText(accountDetails.getAccount());
            amount.setText((int) accountDetails.getAmount());
            trans.setText(accountDetails.getTransaction());

            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                //        listener.onRestaurantSelected(snapshot);
                    }
                }
            });
        }

    }
}
