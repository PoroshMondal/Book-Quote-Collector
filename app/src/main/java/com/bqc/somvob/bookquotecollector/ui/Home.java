package com.bqc.somvob.bookquotecollector.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bqc.somvob.bookquotecollector.MainActivity;
import com.bqc.somvob.bookquotecollector.R;
import com.bqc.somvob.bookquotecollector.adapters.QuoteAdapter;
import com.bqc.somvob.bookquotecollector.databinding.FragmentHomeBinding;
import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.viewModels.OperationalViewModel;
import com.bqc.somvob.bookquotecollector.viewModels.QuoteViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class Home extends Fragment {

    private FragmentHomeBinding binding;
    private NavController navController;

    private QuoteViewModel quoteViewModel;
    private OperationalViewModel opViewModel;

    private QuoteAdapter adapter;

    private MainActivity mActivity;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
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
        opViewModel = new ViewModelProvider(requireActivity()).get(OperationalViewModel.class);

        adapter = new QuoteAdapter();

        setRecyclerView();
        hideShowBottomNavFav();

        opViewModel.getIsFromCollection().observe(getViewLifecycleOwner(), value ->{
            //Toast.makeText(requireActivity(), "Value: " + value, Toast.LENGTH_SHORT).show();
            if (value){
                getAllQuotes();
            }else {
                getAllFavorites();
            }
        });

        binding.extendedFab.setOnClickListener(fabButton -> {
            navController.navigate(R.id.quoteAdd);
        });

    }

    private void getAllQuotes() {
        quoteViewModel.getAllQuotes().observe(getViewLifecycleOwner(), quoteList -> {
            if (quoteList != null) {
                adapter.submitList(quoteList);
            }
        });
    }

    private void getAllFavorites() {
        quoteViewModel.getAllFavorites().observe(getViewLifecycleOwner(), quoteList -> {
            if (quoteList != null) {
                adapter.submitList(quoteList);
            }
        });
    }

    private void setRecyclerView(){
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setNestedScrollingEnabled(false);
        //binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));

        adapter.setOnQuoteClickListener(quote -> {
            opViewModel.setQuotesData(quote);
            navController.navigate(R.id.quoteDetails);
        });
    }

    private void hideShowBottomNavFav(){
        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    // Scroll down
                    binding.extendedFab.hide();
                    mActivity.binding.bottomNavigation.setVisibility(View.GONE);
                } else if (dy < 0) {
                    // Scroll up
                    binding.extendedFab.show();
                    mActivity.binding.bottomNavigation.setVisibility(View.VISIBLE);
                }
            }
        });

        mActivity.binding.bottomNavigation.animate().translationY(mActivity.binding.bottomNavigation.getHeight()).setDuration(400);
        mActivity.binding.bottomNavigation.animate().translationY(0).setDuration(400);
    }

}