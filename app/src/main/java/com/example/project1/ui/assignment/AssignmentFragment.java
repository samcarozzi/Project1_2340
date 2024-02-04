package com.example.project1.ui.assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.databinding.FragmentAssignmentBinding;
import com.example.project1.ui.GTAssignment.Assignment;
import com.example.project1.ui.GTAssignment.GTAssignmentsAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AssignmentFragment extends Fragment {

    private FragmentAssignmentBinding binding;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAssignmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Initialize RecyclerView with dummy data
        initDummyData();
        GTAssignmentsAdapter adapter = new GTAssignmentsAdapter(Assignment.assignments);
        RecyclerView recyclerView = binding.assignmentsRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Handle Add Assignment button click
        binding.addAssignmentButton.setOnClickListener(v -> {
            try {
                String title = binding.assignmentTitleEditText.getText().toString();
                Date dueDate = dateFormat.parse(binding.assignmentDueDateEditText.getText().toString());
                String courseName = binding.assignmentCourseNameEditText.getText().toString();

                // Validate input
                if (title.isEmpty() || dueDate == null || courseName.isEmpty()) {
                    Toast.makeText(getContext(), "Please fill in all fields correctly.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Assignment newAssignment = new Assignment(title, dueDate, courseName);
                adapter.notifyItemInserted(Assignment.assignments.size() - 1);
            } catch (ParseException e) {
                Toast.makeText(getContext(), "Invalid date format.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void initDummyData() {
        Assignment.assignments.clear(); // Clear existing data to avoid duplicates
        //Assignment.assignments.add(new Assignment("Assignment 1", dateFormat.parse("10/10/2023"), "Course 1"));
        //Assignment.assignments.add(new Assignment("Assignment 2", dateFormat.parse("11/11/2023"), "Course 2"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
