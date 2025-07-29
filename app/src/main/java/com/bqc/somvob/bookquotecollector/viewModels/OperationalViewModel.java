package com.bqc.somvob.bookquotecollector.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bqc.somvob.bookquotecollector.entities.Quotes;

public class OperationalViewModel extends ViewModel {
    private MutableLiveData<Boolean> isFromCollection = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsFromCollection() {
        return isFromCollection;
    }

    public void setIsFromCollection(Boolean isFromCollection) {
        this.isFromCollection.postValue(isFromCollection);
    }

    /// /
    private MutableLiveData<Boolean> isForUpdate = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsForUpdate() {
        return isForUpdate;
    }

    public void setIsForUpdate(Boolean isForUpdate) {
        this.isForUpdate.postValue(isForUpdate);
    }

    /// /
    private MutableLiveData<Quotes> quotesData = new MutableLiveData<>();

    public Quotes getQuotesData() {
        return quotesData.getValue();
    }

    public void setQuotesData(Quotes quotes) {
        this.quotesData.setValue(quotes);
    }

}
