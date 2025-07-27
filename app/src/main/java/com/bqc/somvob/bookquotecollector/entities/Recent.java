package com.bqc.somvob.bookquotecollector.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "recent",
        foreignKeys = @ForeignKey(
                entity = Quotes.class,
                parentColumns = "id",
                childColumns = "quoteId",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index(value = "quoteId")}
)
public class Recent {
    @PrimaryKey(autoGenerate = true)
    public int recentId;

    @ColumnInfo(name = "quoteId")
    public int quoteId;
}
