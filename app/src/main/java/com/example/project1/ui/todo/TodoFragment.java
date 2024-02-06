package com.example.project1.ui.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.project1.databinding.FragmentTodoBinding;
import com.example.project1.ui.GTAssignment.Assignment;
import com.example.project1.ui.GTExams.Exams;
import com.example.project1.ui.GTToDoList.GTToDoList;
import com.example.project1.ui.GTToDoList.GTToDoListAdapter;

import java.text.ParseException;
import java.util.ArrayList;

public class TodoFragment extends Fragment {

    private FragmentTodoBinding binding;
    //private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);

    private ArrayList<GTToDoList> todos = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTodoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GTToDoListAdapter adapter = new GTToDoListAdapter(todos);
        binding.todoRecyclerView.setAdapter(adapter);
        binding.todoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Now, set the delete listener using the setter method
        adapter.setOnItemDeleteClickListener(position -> {
            todos.remove(position);
            adapter.notifyItemRemoved(position);
            adapter.notifyItemRangeChanged(position, todos.size());
            Toast.makeText(getContext(), "Assignment removed", Toast.LENGTH_SHORT).show();
        });


        binding.todoRecyclerView.setAdapter(adapter);
        //binding.classesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // Set OnClickListener for the Add Class button
        binding.addTodoItemButton.setOnClickListener(v -> {
            String todoBody = binding.todoItemEditText.getText().toString();

            //String examTime = binding.examTimeEditText.getText().toString();
            //String examLocation = binding.examLocationEditText.getText().toString();
            //String examDetails = binding.examDetailsEditText.getText().toString();


            // Validate input (simple validation)
            if (!todoBody.isEmpty()) {
                // Create new GTClass object and add it to the list
                GTToDoList newTodo = new GTToDoList(todoBody);
                todos.add(newTodo);
                adapter.notifyItemInserted(todos.size() - 1);
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