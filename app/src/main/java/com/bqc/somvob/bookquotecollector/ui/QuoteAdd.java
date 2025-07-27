package com.bqc.somvob.bookquotecollector.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bqc.somvob.bookquotecollector.databinding.FragmentQuoteAddBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class QuoteAdd extends Fragment {

    private FragmentQuoteAddBinding binding;

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
}