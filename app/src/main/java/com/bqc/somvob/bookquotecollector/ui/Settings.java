package com.bqc.somvob.bookquotecollector.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bqc.somvob.bookquotecollector.databinding.FragmentSettingsBinding;

public class Settings extends Fragment {

    private FragmentSettingsBinding binding;

    public Settings() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}