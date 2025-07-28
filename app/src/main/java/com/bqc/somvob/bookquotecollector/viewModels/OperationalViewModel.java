package com.bqc.somvob.bookquotecollector.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bqc.somvob.bookquotecollector.entities.Quotes;

public class OperationalViewModel extends ViewModel {
    private MutableLiveData<Quotes> quotesData;

    public MutableLiveData<Quotes> getQuotesData() {
        return quotesData;
    }

    public void setQuotesData(MutableLiveData<Quotes> quotesData) {
        this.quotesData = quotesData;
    }
}
