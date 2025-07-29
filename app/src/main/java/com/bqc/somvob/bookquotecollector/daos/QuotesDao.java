package com.bqc.somvob.bookquotecollector.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.bqc.somvob.bookquotecollector.entities.Quotes;

import java.util.List;

@Dao
public interface QuotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertQuote(Quotes quote);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateQuote(Quotes quote);

    @Query("SELECT * FROM quotes")
    LiveData<List<Quotes>> getAllQuotes();

    @Delete
    void deleteQuote(Quotes quote);

}
