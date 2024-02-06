package com.example.project1.ui.GTAssignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class GTAssignmentsAdapter extends RecyclerView.Adapter<GTAssignmentsAdapter.AssignmentViewHolder> {
    private List<Assignment> assignmentList;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());

    // Use the correct interface within this adapter class
    private OnItemDeleteClickListener deleteClickListener;

    public GTAssignmentsAdapter(List<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public void setOnItemDeleteClickListener(OnItemDeleteClickListener listener) {
        this.deleteClickListener = listener;
    }

    // Correctly reference the interface defined within this class
    public interface OnItemDeleteClickListener {
        void onItemDelete(int position);
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_item, parent, false);
        return new AssignmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        Assignment assignment = assignmentList.get(position);
        holder.assignmentTitleTextView.setText("Title: " + assignment.getTitle());
        holder.dueDateTextView.setText("Due Date: " + dateFormat.format(assignment.getDateDue()));
        holder.courseNameTextView.setText("Course: " + assignment.getcourseName());

        // Ensure deleteClickListener is not null before invoking
        holder.assignmentDeleteButton.setOnClickListener(v -> {
            if (deleteClickListener != null) {
                deleteClickListener.onItemDelete(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    static class AssignmentViewHolder extends RecyclerView.ViewHolder {
        Button assignmentDeleteButton;
        TextView assignmentTitleTextView, dueDateTextView, courseNameTextView;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            assignmentTitleTextView = itemView.findViewById(R.id.assignmentTitleTextView);
            dueDateTextView = itemView.findViewById(R.id.dueDateTextView);
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            assignmentDeleteButton = itemView.findViewById(R.id.assignmentDeleteButton);
        }
    }
}
