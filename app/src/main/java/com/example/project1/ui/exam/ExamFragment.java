package com.example.project1.ui.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.project1.databinding.FragmentExamBinding;
import com.example.project1.ui.GTClass.GTClass;
import com.example.project1.ui.GTClass.GTClassAdapter;
import com.example.project1.ui.GTExams.Exams;
import com.example.project1.ui.GTExams.GTExamsAdapter;


import java.util.ArrayList;
import java.util.Objects;


public class ExamFragment extends Fragment {
    private FragmentExamBinding binding;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
    private ArrayList<Exams> gtExams = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExamBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GTExamsAdapter adapter = new GTExamsAdapter(gtExams);
        binding.examsRecyclerView.setAdapter(adapter);
        binding.examsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Now, set the delete listener using the setter method



        binding.examsRecyclerView.setAdapter(adapter);
        //binding.classesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // Set OnClickListener for the Add Class button
        binding.addExamButton.setOnClickListener(v -> {
            String classTitle = binding.examTitleEditText.getText().toString();
            Date examDate = null;
            try {
                examDate = dateFormat.parse(binding.examDateEditText.getText().toString());
            } catch (ParseException e) {
                Toast.makeText(getContext(), "Invalid date format.", Toast.LENGTH_SHORT).show();
            }
            String examTime = binding.examTimeEditText.getText().toString();
            String examLocation = binding.examLocationEditText.getText().toString();
            String examDetails = binding.examDetailsEditText.getText().toString();


            // Validate input (simple validation)
            if (!classTitle.isEmpty() && examDate != null && !examTime.isEmpty() && !examLocation.isEmpty() && !examDetails.isEmpty()) {
                // Create new GTClass object and add it to the list
                Exams newClass = new Exams(classTitle, examDate, examTime, examLocation, examDetails);
                gtExams.add(newClass);
                adapter.notifyItemInserted(gtExams.size() - 1);
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