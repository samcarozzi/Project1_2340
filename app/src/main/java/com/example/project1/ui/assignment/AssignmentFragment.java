package com.example.project1.ui.assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.project1.databinding.FragmentAssignmentBinding;
import com.example.project1.ui.GTAssignment.Assignment;
import com.example.project1.ui.GTAssignment.GTAssignmentsAdapter;

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

        // Initialize RecyclerView
        initDummyData();
        GTAssignmentsAdapter adapter = new GTAssignmentsAdapter(Assignment.assignments);
        binding.assignmentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.assignmentsRecyclerView.setAdapter(adapter);

        // Add delete functionality
        adapter.setOnItemDeleteClickListener(position -> {
            Assignment.assignments.remove(position);
            adapter.notifyItemRemoved(position);
            adapter.notifyItemRangeChanged(position, Assignment.assignments.size());
            Toast.makeText(getContext(), "Assignment removed", Toast.LENGTH_SHORT).show();
        });

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
                Assignment.assignments.add(newAssignment); // Add new assignment to the list
                adapter.notifyItemInserted(Assignment.assignments.size() - 1);
            } catch (ParseException e) {
                Toast.makeText(getContext(), "Invalid date format.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void initDummyData() {
        // Initialize your dummy data here
        // Ensure to handle ParseException or set dates directly if fixed
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
