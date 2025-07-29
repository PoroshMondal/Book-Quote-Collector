package com.bqc.somvob.bookquotecollector.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.entities.Recent;
import com.bqc.somvob.bookquotecollector.repos.QuoteRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.scopes.ViewModelScoped;

@HiltViewModel
public class QuoteViewModel extends ViewModel {

    private final QuoteRepository repository;
    private ExecutorService executorService;

    /*private final LiveData<List<Quotes>> allQuotes;
    private final LiveData<List<Favorite>> allFavorites;
    private final LiveData<List<Recent>> allRecentQuotes;*/

    @Inject
    public QuoteViewModel(QuoteRepository repository) {
        this.repository = repository;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    // Quote
    public LiveData<List<Quotes>> getAllQuotes() {
        return repository.getAllQuotes();
    }

    public void insertQuote(Quotes quote) {
        executorService.execute(() -> repository.insertQuote(quote));
    }

    public void deleteQuote(Quotes quote){
        repository.deleteQuote(quote);
    }

    // Favorite
    public LiveData<List<Quotes>> getAllFavorites() {
        return repository.getAllFavorites();
    }

    public void insertFavorite(Favorite favorite) {
        executorService.execute(() -> repository.insertFavorite(favorite));
        //repository.insertFavorite(favorite);
    }

    public void removeFavorite(int id) {
        executorService.execute(() -> repository.removeFavorite(id));
    }

    // Recent
   /* public LiveData<List<Recent>> getAllRecentQuote() {
        return repository.getAllRecentQuote();
    }*/

    public void insertRecent(Recent recent) {
        repository.insertRecent(recent);
    }

    public void clearAllRecentQuotes(Recent recent) {
        repository.clearAllRecentQuotes(recent);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        executorService.shutdown(); // Clean up
    }

}
