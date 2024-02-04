package com.example.project1.ui.GTClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.R;
import java.util.List;

public class GTClassAdapter extends RecyclerView.Adapter<GTClassAdapter.GTClassViewHolder> {
    private List<GTClass> gtClassList;

    public GTClassAdapter(List<GTClass> gtClassList) {
        this.gtClassList = gtClassList;
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
        holder.courseNameTextView.setText(gtClass.getCourseName());
        holder.timeTextView.setText(gtClass.getTime());
        holder.instructorTextView.setText(gtClass.getInstructor());
    }

    @Override
    public int getItemCount() {
        return gtClassList.size();
    }

    static class GTClassViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTextView, timeTextView, instructorTextView;

        public GTClassViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTextView = itemView.findViewById(R.id.courseNameTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            instructorTextView = itemView.findViewById(R.id.instructorTextView);
        }
    }
}
