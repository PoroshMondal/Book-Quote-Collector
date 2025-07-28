package com.bqc.somvob.bookquotecollector.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bqc.somvob.bookquotecollector.databinding.SingleRowQuoteBinding;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.interfaces.OnQuoteClickListener;

public class QuoteAdapter extends ListAdapter<Quotes, QuoteAdapter.ViewHolder> {

    private OnQuoteClickListener clickListener;

    public QuoteAdapter() {
        super(DIFF_CALLBACK);
    }

    public void setOnQuoteClickListener(OnQuoteClickListener listener) {
        this.clickListener = listener;
    }

    private static final DiffUtil.ItemCallback<Quotes> DIFF_CALLBACK = new DiffUtil.ItemCallback<Quotes>() {
        @Override
        public boolean areItemsTheSame(@NonNull Quotes oldItem, @NonNull Quotes newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Quotes oldItem, @NonNull Quotes newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleRowQuoteBinding binding = SingleRowQuoteBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position),position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SingleRowQuoteBinding binding;
        public ViewHolder(@NonNull SingleRowQuoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Quotes quotes, int position){
            binding.setQuoteModel(quotes);

            binding.getRoot().setOnClickListener(v -> {
                if (clickListener != null) {
                    clickListener.onQuoteItemClick(quotes);
                }
            });
        }

    }

}
