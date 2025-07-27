package com.bqc.somvob.bookquotecollector.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bqc.somvob.bookquotecollector.daos.FavoriteDao;
import com.bqc.somvob.bookquotecollector.daos.QuotesDao;
import com.bqc.somvob.bookquotecollector.daos.RecentDao;
import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.entities.Recent;

@Database(entities = {Quotes.class, Favorite.class, Recent.class}, version = 1)
public abstract class QuoteDatabase extends RoomDatabase {

    public abstract QuotesDao quoteDao();
    public abstract FavoriteDao favoriteDao();
    public abstract RecentDao recentDao();

    private static final String DB_NAME = "book_collector_db";
    private static volatile QuoteDatabase mDbInstance;

    public static QuoteDatabase getDbInstance(Context context) {
        if (mDbInstance == null) {
            synchronized (QuoteDatabase.class) {
                if (mDbInstance == null) {
                    mDbInstance = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    QuoteDatabase.class,
                                    DB_NAME
                            )
                            // .fallbackToDestructiveMigration() // Uncomment if needed
                            .build();
                }
            }
        }
        return mDbInstance;
    }

}
