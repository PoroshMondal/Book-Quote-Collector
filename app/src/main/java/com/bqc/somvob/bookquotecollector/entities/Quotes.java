package com.bqc.somvob.bookquotecollector.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quotes")
public class Quotes {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "book_title")
    private String title;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "quote")
    private String quote;

    @ColumnInfo(name = "category")
    private String category;

    public Quotes(int id, String title, String author, String quote, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quote = quote;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
