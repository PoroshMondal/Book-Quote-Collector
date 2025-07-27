package com.bqc.somvob.bookquotecollector.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bqc.somvob.bookquotecollector.databinding.FragmentQuoteDetailsBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class QuoteDetails extends Fragment {

    private FragmentQuoteDetailsBinding binding;

    public QuoteDetails() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuoteDetailsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnEdit.setOnClickListener(edit -> {
            Toast.makeText(requireActivity(), "Edit", Toast.LENGTH_SHORT).show();
        });

        binding.btnFav.setOnClickListener(fav->{
            Toast.makeText(requireActivity(), "Fav", Toast.LENGTH_SHORT).show();
        });

        binding.btnDelete.setOnClickListener(delete->{
            Toast.makeText(requireActivity(), "Delete", Toast.LENGTH_SHORT).show();
        });

    }
}