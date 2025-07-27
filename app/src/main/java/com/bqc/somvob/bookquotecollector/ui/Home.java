package com.bqc.somvob.bookquotecollector.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bqc.somvob.bookquotecollector.MainActivity;
import com.bqc.somvob.bookquotecollector.R;
import com.bqc.somvob.bookquotecollector.databinding.FragmentHomeBinding;
import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.viewModels.QuoteViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class Home extends Fragment {

    private FragmentHomeBinding binding;
    private NavController navController;

    private QuoteViewModel quoteViewModel;

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
        navController = NavHostFragment.findNavController(this);
        quoteViewModel = new ViewModelProvider(requireActivity()).get(QuoteViewModel.class);

        /*quoteViewModel.insertQuote(new Quotes(
                1,
                "Title",
                "Author",
                "afhdsklfa asdhfls fkldsfj fjdkls fjklslafjdka jlasfkj ",
                "Sample Category"
        ));

        quoteViewModel.getAllQuotes().observe(getViewLifecycleOwner(), data -> {
            if (data!=null){
                Toast.makeText(requireActivity(), "Quotes: " + data.get(0).getId(), Toast.LENGTH_SHORT).show();
            }
        });*/

        //quoteViewModel.insertFavorite(new Favorite(1,1));
        quoteViewModel.getAllFavorites().observe(getViewLifecycleOwner(),data ->{
            if (data!=null){
                //Toast.makeText(requireActivity(), "Fav: " + data.get(0).getQuote(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.extendedFab.setOnClickListener(fabButton -> {
            navController.navigate(R.id.quoteAdd);
            Toast.makeText(requireActivity(), "Add Auote", Toast.LENGTH_SHORT).show();
        });



    }
}