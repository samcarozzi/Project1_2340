package com.example.project1.ui.classStore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClassStoreFragmentViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ClassStoreFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is class fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
