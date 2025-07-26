package com.bqc.somvob.bookquotecollector.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bqc.somvob.bookquotecollector.MainActivity;
import com.bqc.somvob.bookquotecollector.databinding.FragmentHomeBinding;

public class Home extends Fragment {

    private FragmentHomeBinding binding;
    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.extendedFab.setOnClickListener(fabButton -> {
            Toast.makeText(requireActivity(), "Search", Toast.LENGTH_SHORT).show();
        });

    }
}