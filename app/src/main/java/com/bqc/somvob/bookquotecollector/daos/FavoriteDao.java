package com.bqc.somvob.bookquotecollector.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;

import java.util.List;

@Dao
public interface FavoriteDao {
    @Insert
    void insertFavorite(Favorite favorite);

    @Delete
    void removeFavorite(Favorite favorite);

    @Query("SELECT q.* FROM quotes q INNER JOIN favorite f ON q.id = f.quoteId ORDER BY ID DESC")
    List<Quotes> getFavoriteQuotes();

}
