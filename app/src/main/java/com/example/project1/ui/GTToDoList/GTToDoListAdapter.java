package com.example.project1.ui.GTToDoList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.R;
import com.example.project1.ui.GTExams.Exams;
import com.example.project1.ui.GTExams.GTExamsAdapter;
import com.example.project1.ui.GTToDoList.GTToDoListAdapter;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
public class GTToDoListAdapter extends RecyclerView.Adapter<GTToDoListAdapter.AssignmentViewHolder>{

    private List<GTToDoList> todoList;

    private GTToDoListAdapter.OnItemDeleteClickListener deleteClickListener;


    public GTToDoListAdapter(List<GTToDoList> assignmentList) {
        this.todoList = assignmentList;
    }

    @NonNull
    @Override
    public GTToDoListAdapter.AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new GTToDoListAdapter.AssignmentViewHolder(view);
    }

    public void setOnItemDeleteClickListener(GTToDoListAdapter.OnItemDeleteClickListener listener) {
        this.deleteClickListener = listener;
    }

    // Correctly reference the interface defined within this class
    public interface OnItemDeleteClickListener {
        void onItemDelete(int position);
    }

    @Override
    public void onBindViewHolder(@NonNull GTToDoListAdapter.AssignmentViewHolder holder, int position) {
        GTToDoList todo = todoList.get(position);
        holder.todoItemTextView.setText("Title: " + todo.getBody());
        holder.todoDeleteButton.setOnClickListener(v -> {
            if (deleteClickListener != null) {
                deleteClickListener.onItemDelete(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    static class AssignmentViewHolder extends RecyclerView.ViewHolder {
        TextView todoItemTextView;

        Button todoDeleteButton;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            todoItemTextView = itemView.findViewById(R.id.todoItemTextView);
            todoDeleteButton = itemView.findViewById(R.id.todoDeleteButton);

        }
    }
}
