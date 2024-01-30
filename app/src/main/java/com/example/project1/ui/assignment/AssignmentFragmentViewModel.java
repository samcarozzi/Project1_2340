package com.example.project1.ui.assignment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AssignmentFragmentViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AssignmentFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is assignment fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}