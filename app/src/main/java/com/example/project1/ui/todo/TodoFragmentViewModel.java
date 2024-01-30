package com.example.project1.ui.todo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TodoFragmentViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TodoFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is todo fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}