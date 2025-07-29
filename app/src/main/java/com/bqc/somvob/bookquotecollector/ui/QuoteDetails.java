package com.bqc.somvob.bookquotecollector.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bqc.somvob.bookquotecollector.MainActivity;
import com.bqc.somvob.bookquotecollector.databinding.FragmentQuoteDetailsBinding;
import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.viewModels.OperationalViewModel;
import com.bqc.somvob.bookquotecollector.viewModels.QuoteViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class QuoteDetails extends Fragment {

    private FragmentQuoteDetailsBinding binding;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        quoteViewModel = new ViewModelProvider(requireActivity()).get(QuoteViewModel.class);
        opViewModel = new ViewModelProvider(requireActivity()).get(OperationalViewModel.class);

        Quotes quotes = opViewModel.getQuotesData();
        //Toast.makeText(requireActivity(), opViewModel.getQuotesData().getQuote() + "Edit", Toast.LENGTH_SHORT).show();

        binding.txtTitle.setText(quotes.getTitle());
        binding.txtAuthor.setText(quotes.getAuthor());
        binding.txtQuoteDetails.setText(quotes.getQuote());

        binding.btnEdit.setOnClickListener(edit -> {
            Toast.makeText(requireActivity(), "Edit", Toast.LENGTH_SHORT).show();
        });

        binding.btnFav.setOnClickListener(fav->{
            quoteViewModel.insertFavorite(new Favorite(0,quotes.getId()));
            Toast.makeText(requireActivity(), "Fav", Toast.LENGTH_SHORT).show();
        });

        binding.btnDelete.setOnClickListener(delete->{
            quoteViewModel.removeFavorite(quotes.getId());
            //Toast.makeText(requireActivity(), "Delete", Toast.LENGTH_SHORT).show();
        });

    }
}