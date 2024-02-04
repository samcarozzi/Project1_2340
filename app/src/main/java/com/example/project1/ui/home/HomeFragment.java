package com.example.project1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.project1.databinding.FragmentHomeBinding;
import com.example.project1.ui.GTClass.GTClass;
import com.example.project1.ui.GTClass.GTClassAdapter;
import com.google.android.material.textfield.TextInputLayout;

import com.example.project1.R;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<GTClass> gtClasses = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Setup RecyclerView with existing gtClasses
        GTClassAdapter adapter = new GTClassAdapter(gtClasses);
        binding.classesRecyclerView.setAdapter(adapter);
        binding.classesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Set OnClickListener for the Add Class button
        binding.addClassButton.setOnClickListener(v -> {
            String classTitle = binding.classTitleEditText.getText().toString();
            String timeRange = binding.timeRangeEditText.getText().toString();
            String teacherName = binding.teacherNameEditText.getText().toString();

            // Validate input (simple validation)
            if (!classTitle.isEmpty() && !timeRange.isEmpty() && !teacherName.isEmpty()) {
                // Create new GTClass object and add it to the list
                GTClass newClass = new GTClass(classTitle, timeRange, teacherName);
                gtClasses.add(newClass);
                adapter.notifyItemInserted(gtClasses.size() - 1);
            } else {
                Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
