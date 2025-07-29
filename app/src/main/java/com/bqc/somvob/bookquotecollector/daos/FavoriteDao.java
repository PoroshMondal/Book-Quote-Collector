package com.bqc.somvob.bookquotecollector.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bqc.somvob.bookquotecollector.entities.Favorite;
import com.bqc.somvob.bookquotecollector.entities.Quotes;

import java.util.List;

@Dao
public interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFavorite(Favorite favorite);

    @Query("SELECT COUNT(*) FROM favorite WHERE quoteId = :quoteId")
    int isFavoriteExists(int quoteId);

    @Query("DELETE FROM favorite WHERE quoteId = :id")
    void removeFavorite(int id);

    //@Query("SELECT q.* FROM quotes q INNER JOIN favorite f ON q.id = f.favId ORDER BY ID DESC")
    @Query("SELECT q.* FROM quotes q INNER JOIN favorite f ON q.id = f.favId")
    LiveData<List<Quotes>> getFavoriteQuotes();

}
