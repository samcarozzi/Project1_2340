package com.example.project1.ui.GTExams;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.R;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class GTExamsAdapter extends RecyclerView.Adapter<GTExamsAdapter.AssignmentViewHolder> {
    private List<Exams> examsList;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());

    public GTExamsAdapter(List<Exams> assignmentList) {
        this.examsList = assignmentList;
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exams_item, parent, false);
        return new AssignmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        Exams exam = examsList.get(position);
        holder.examsTitleTextView.setText("Title: " + exam.getTitle());
        holder.dueDateTextView.setText("Date: " + dateFormat.format(exam.getDate()));
        holder.timeTextView.setText("Time: " + exam.getTime());
        holder.locationTextView.setText("Location: " + exam.getLocation());
        holder.detailsTextView.setText("Details: " + exam.getDetails());

    }

    @Override
    public int getItemCount() {
        return examsList.size();
    }

    static class AssignmentViewHolder extends RecyclerView.ViewHolder {
        TextView examsTitleTextView, dueDateTextView, timeTextView, locationTextView, detailsTextView;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            examsTitleTextView = itemView.findViewById(R.id.examsTitleTextView);
            dueDateTextView = itemView.findViewById(R.id.dueDateTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            detailsTextView = itemView.findViewById(R.id.detailsTextView);

        }
    }
}
