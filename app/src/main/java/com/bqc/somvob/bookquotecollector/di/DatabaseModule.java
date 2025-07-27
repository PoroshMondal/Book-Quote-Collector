package com.bqc.somvob.bookquotecollector.di;

import android.content.Context;

import com.bqc.somvob.bookquotecollector.daos.FavoriteDao;
import com.bqc.somvob.bookquotecollector.daos.QuotesDao;
import com.bqc.somvob.bookquotecollector.daos.RecentDao;
import com.bqc.somvob.bookquotecollector.db.QuoteDatabase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import jakarta.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {
    @Provides
    @Singleton
    public static QuoteDatabase provideExpenseDatabase(@ApplicationContext Context context) {
        return QuoteDatabase.getDbInstance(context);
    }

    @Provides
    @Singleton
    public static QuotesDao provideQuoteDao(QuoteDatabase quoteDatabase) {
        return quoteDatabase.quoteDao();
    }

    @Provides
    @Singleton
    public static FavoriteDao provideFavoriteDao(QuoteDatabase quoteDatabase) {
        return quoteDatabase.favoriteDao();
    }

    @Provides
    @Singleton
    public static RecentDao provideRecentDao(QuoteDatabase quoteDatabase) {
        return quoteDatabase.recentDao();
    }

}
