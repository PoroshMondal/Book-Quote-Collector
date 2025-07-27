package com.bqc.somvob.bookquotecollector.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bqc.somvob.bookquotecollector.databinding.FragmentQuoteAddBinding;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.viewModels.QuoteViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class QuoteAdd extends Fragment {

    private FragmentQuoteAddBinding binding;
    private QuoteViewModel quoteViewModel;

    public QuoteAdd() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuoteAddBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quoteViewModel = new ViewModelProvider(requireActivity()).get(QuoteViewModel.class);

        binding.btnAdd.setOnClickListener(v -> {
            if (validate()){
                String title = binding.etTitle.text.toString();
                String author = binding.etAuthor.text.toString();
                String quote = binding.etQuote.text.toString();
                String category = binding.etQuoteCategory.text.toString();

                Quotes quotes = new Quotes(1,title,author,quote,category);
                quoteViewModel.insertQuote(quotes);
            }
        });

    }

    private boolean validate(){
        if (binding.etQuote.text.toString().empty()){
            binding.layoutQuote.setError("Required!");
            return false;
        }

        return true;
    }

}