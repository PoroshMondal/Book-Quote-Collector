package com.bqc.somvob.bookquotecollector.repos;

import androidx.lifecycle.LiveData;

import com.bqc.somvob.bookquotecollector.daos.FavoriteDao;
import com.bqc.somvob.bookquotecollector.daos.QuotesDao;
import com.bqc.somvob.bookquotecollector.daos.RecentDao;
import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.entities.Recent;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class QuoteRepository {
    private final QuotesDao quoteDao;
    private final FavoriteDao favoriteDao;
    private final RecentDao recentDao;

    @Inject
    public QuoteRepository(QuotesDao quoteDao, FavoriteDao favoriteDao, RecentDao recentDao) {
        this.quoteDao = quoteDao;
        this.favoriteDao = favoriteDao;
        this.recentDao = recentDao;
    }

    // Quote operations
    public LiveData<List<Quotes>> getAllQuotes() {
        return quoteDao.getAllQuotes();
    }

    public void insertQuote(Quotes quote) {
        quoteDao.insertQuote(quote);
    }

    public void updateQuote(Quotes quote) {
        quoteDao.updateQuote(quote);
    }

    public void deleteQuote(Quotes quote){
        quoteDao.deleteQuote(quote);
    }

    public LiveData<List<Quotes>> searchQuotes(String sQuery){
        return quoteDao.searchQuotes(sQuery);
    }

    // Favorite operations
    public LiveData<List<Quotes>> getAllFavorites() {
        return favoriteDao.getFavoriteQuotes();
    }

    public void insertFavorite(Favorite favorite) {
        favoriteDao.insertFavorite(favorite);
    }

    public void removeFavorite(int id) {
        favoriteDao.removeFavorite(id);
    }

    // Recent operations
    public LiveData<List<Quotes>> getAllRecentQuote() {
        return recentDao.getRecentQuotes();
    }

    public void insertRecent(Recent recent) {
        recentDao.insertRecentQuotes(recent);
    }

    public void clearAllRecentQuotes(Recent recent) {
        recentDao.clearAllRecentQuotes();
    }

}
