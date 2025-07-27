package com.bqc.somvob.bookquotecollector.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.bqc.somvob.bookquotecollector.entities.Quotes;

import java.util.List;

@Dao
public interface QuotesDao {
    @Insert
    void insertQuote(Quotes quote);

    @Query("SELECT * FROM quotes")
    List<Quotes> getAllQuotes();

    @Delete
    void deleteQuote(Quotes quote);

}
