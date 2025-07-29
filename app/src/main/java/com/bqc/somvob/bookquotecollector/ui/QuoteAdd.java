package com.bqc.somvob.bookquotecollector.ui;

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
import com.bqc.somvob.bookquotecollector.databinding.FragmentQuoteAddBinding;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.viewModels.OperationalViewModel;
import com.bqc.somvob.bookquotecollector.viewModels.QuoteViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class QuoteAdd extends Fragment {

    private FragmentQuoteAddBinding binding;
    private NavController navController;
    private MainActivity mActivity;

    private QuoteViewModel quoteViewModel;
    private OperationalViewModel opViewModel;

    private int quoteId = 0;

    public QuoteAdd() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
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
        navController = NavHostFragment.findNavController(this);
        quoteViewModel = new ViewModelProvider(requireActivity()).get(QuoteViewModel.class);
        opViewModel = new ViewModelProvider(requireActivity()).get(OperationalViewModel.class);

        opViewModel.getIsForUpdate().observe(getViewLifecycleOwner(), value -> {
            if (value){
                quoteId = opViewModel.getQuotesData().getId();

                binding.etTitle.setText(opViewModel.getQuotesData().getTitle());
                binding.etAuthor.setText(opViewModel.getQuotesData().getAuthor());
                binding.etQuote.setText(opViewModel.getQuotesData().getQuote());
                binding.etQuoteCategory.setText(opViewModel.getQuotesData().getCategory());

                binding.btnAdd.setText(getString(R.string.update_quote));
            }
        });

        binding.btnAdd.setOnClickListener(v -> {
            String title = binding.etTitle.getText().toString().trim();
            String author = binding.etAuthor.getText().toString().trim();
            String quote = binding.etQuote.getText().toString().trim();
            String category = binding.etQuoteCategory.getText().toString().trim();

            if (binding.btnAdd.getText().toString().equalsIgnoreCase(getString(R.string.add_quote))){
                if (validate()){
                    Quotes quotes = new Quotes(0,title,author,quote,category);
                    quoteViewModel.insertQuote(quotes);
                }
            }else {
                if (validate()){
                    Quotes quotes = new Quotes(quoteId,title,author,quote,category);
                    quoteViewModel.updateQuote(quotes);
                    opViewModel.setIsForUpdate(false);
                }
            }

            opViewModel.setIsFromCollection(true);
            navController.navigate(R.id.home_main, null, mActivity.clearBackStack());

        });

    }

    private boolean validate(){
        if (binding.etQuote.getText().toString().isEmpty()){
            binding.layoutQuote.setError("Required!");
            return false;
        }

        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //opViewModel.setIsForUpdate(false);
    }
}