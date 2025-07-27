package com.bqc.somvob.bookquotecollector.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bqc.somvob.bookquotecollector.entities.Quotes;
import com.bqc.somvob.bookquotecollector.entities.Recent;

import java.util.List;

@Dao
public interface RecentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRecentQuotes(Recent recent);

    @Query("SELECT q.* FROM quotes q INNER JOIN recent r ON q.id = r.quoteId ORDER BY ID DESC")
    LiveData<List<Quotes>> getRecentQuotes();

    @Query("DELETE FROM recent")
    void clearAllRecentQuotes();
}
