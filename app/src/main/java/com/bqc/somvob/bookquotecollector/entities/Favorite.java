package com.bqc.somvob.bookquotecollector.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "favorite",
        foreignKeys = @ForeignKey(
                entity = Quotes.class,
                parentColumns = "id",
                childColumns = "quoteId",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = "quoteId")}
)
public class Favorite {
    @PrimaryKey(autoGenerate = true)
    public int favId;

    @ColumnInfo(name = "quoteId")
    public int quoteId;

    public Favorite(int favId, int quoteId) {
        this.favId = favId;
        this.quoteId = quoteId;
    }

    public int getFavId() {
        return favId;
    }

    public void setFavId(int favId) {
        this.favId = favId;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }
}
