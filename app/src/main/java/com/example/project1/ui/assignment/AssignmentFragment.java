package com.example.project1.ui.assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.project1.databinding.FragmentAssignmentBinding;
import com.example.project1.ui.assignment.AssignmentFragmentViewModel;

public class AssignmentFragment extends Fragment {

    private FragmentAssignmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AssignmentFragmentViewModel assignmentFragmentViewModel =
                new ViewModelProvider(this).get(AssignmentFragmentViewModel.class);

        binding = FragmentAssignmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.assignmentStore;
        assignmentFragmentViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}