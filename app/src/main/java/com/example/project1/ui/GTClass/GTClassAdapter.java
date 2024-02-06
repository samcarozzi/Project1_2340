package com.example.project1.ui.GTClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.R;
import com.example.project1.ui.GTClass.GTClassAdapter;

import java.util.List;

public class GTClassAdapter extends RecyclerView.Adapter<GTClassAdapter.GTClassViewHolder> {
    private List<GTClass> gtClassList;
    private OnItemDeleteClickListener deleteClickListener;

    public GTClassAdapter(List<GTClass> gtClassList) {
        this.gtClassList = gtClassList;
        //this.deleteClickListener = deleteClickListener;
    }

    public void setOnItemDeleteClickListener(OnItemDeleteClickListener listener) {
        this.deleteClickListener = listener;
    }

    public interface OnItemDeleteClickListener {
        void onItemDelete(int position);
    }

    private GTClassAdapter.OnItemEditClickListener editClickListener;

    public interface OnItemEditClickListener {
        void onItemEdit(int position);
    }

    public void setOnItemEditClickListener(GTClassAdapter.OnItemEditClickListener listener) {
        this.editClickListener = listener;
    }

    @NonNull
    @Override
    public GTClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gt_class_item, parent, false);
        return new GTClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GTClassViewHolder holder, int position) {
        GTClass gtClass = gtClassList.get(position);
        holder.courseNameTextView.setText("Class Title: " + gtClass.getCourseName());
        holder.timeTextView.setText("Time: " + gtClass.getTime());
        holder.instructorTextView.setText("Instructor: " + gtClass.getInstructor());
        holder.deleteButton.setOnClickListener(v -> deleteClickListener.onItemDelete(position));

        holder.classEditButton.setOnClickListener(v -> {
            if (editClickListener != null) {
                editClickListener.onItemEdit(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return gtClassList.size();
    }

    static class GTClassViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTextView, timeTextView, instructorTextView;
        Button deleteButton, classEditButton;

        GTClassViewHolder(View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            instructorTextView = itemView.findViewById(R.id.instructorTextView);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            classEditButton = itemView.findViewById(R.id.classEditButton);
        }
    }


}
