package com.example.project1.ui.exam;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExamFragmentViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ExamFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is exam fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
