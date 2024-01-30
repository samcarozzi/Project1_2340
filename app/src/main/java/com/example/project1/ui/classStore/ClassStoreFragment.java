package com.example.project1.ui.classStore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.project1.databinding.FragmentClassStoreBinding;

public class ClassStoreFragment extends Fragment {
    private FragmentClassStoreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClassStoreFragmentViewModel classStoreViewModel =
                new ViewModelProvider(this).get(ClassStoreFragmentViewModel.class);

        binding = FragmentClassStoreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.classStore;
        classStoreViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
