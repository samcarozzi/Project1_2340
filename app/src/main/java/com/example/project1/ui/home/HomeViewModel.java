package com.example.project1.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> mText2;
    private final MutableLiveData<String> inputListText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        mText2 = new MutableLiveData<>();
        mText2.setValue("Bruh");

        inputListText = new MutableLiveData<>();
        inputListText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getInputListText() {
        return inputListText;
    }

    public void addInput(String input) {
        String currentText = inputListText.getValue();
        if (currentText == null) currentText = "";
        inputListText.setValue(currentText + "\n" + input);
    }
}
