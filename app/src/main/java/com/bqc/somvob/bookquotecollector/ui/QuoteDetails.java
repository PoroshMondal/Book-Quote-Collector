package com.bqc.somvob.bookquotecollector.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bqc.somvob.bookquotecollector.MainActivity;
import com.bqc.somvob.bookquotecollector.R;
import com.bqc.somvob.bookquotecollector.databinding.FragmentQuoteDetailsBinding;
import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.viewModels.OperationalViewModel;
import com.bqc.somvob.bookquotecollector.viewModels.QuoteViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class QuoteDetails extends Fragment {

    private FragmentQuoteDetailsBinding binding;
    private NavController navController;

    private QuoteViewModel quoteViewModel;
    private OperationalViewModel opViewModel;

    private MainActivity mActivity;

    public QuoteDetails() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuoteDetailsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = NavHostFragment.findNavController(this);
        quoteViewModel = new ViewModelProvider(requireActivity()).get(QuoteViewModel.class);
        opViewModel = new ViewModelProvider(requireActivity()).get(OperationalViewModel.class);

        Quotes quotes = opViewModel.getQuotesData();

        favBtnVisibleHide(quotes.getId());

        binding.txtTitle.setText(quotes.getTitle());
        binding.txtAuthor.setText(quotes.getAuthor());
        binding.txtQuoteDetails.setText(quotes.getQuote());

        binding.btnEdit.setOnClickListener(edit -> {
            opViewModel.setIsForUpdate(true);
            navController.navigate(R.id.quoteAdd, null, mActivity.clearBackStack());
        });

        binding.btnFav.setOnClickListener(fav->{
            quoteViewModel.insertFavorite(new Favorite(0,quotes.getId()));
            binding.btnFav.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_filled));
            binding.btnDelete.setVisibility(View.VISIBLE);
        });

        binding.btnDelete.setOnClickListener(delete->{
            quoteViewModel.removeFavorite(quotes.getId());
            opViewModel.setIsFromCollection(false);
            navController.navigate(R.id.home_main, null, mActivity.clearBackStack());

        });

    }


    private void favBtnVisibleHide(int id){
        quoteViewModel.isFavoriteExists(id).observe(getViewLifecycleOwner(), value -> {
            if (value>0){
                binding.btnFav.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_filled));
                binding.btnDelete.setVisibility(View.VISIBLE);
            }else {
                binding.btnDelete.setVisibility(View.GONE);
            }
        });
    }

}