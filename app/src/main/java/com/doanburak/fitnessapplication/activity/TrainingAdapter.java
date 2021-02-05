package com.doanburak.fitnessapplication.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doanburak.fitnessapplication.R;
import com.doanburak.fitnessapplication.model.Training;

import java.util.ArrayList;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingViewholder> {

    private final ArrayList<Training> trainingList = new ArrayList<>();

    @NonNull
    @Override
    public TrainingViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_show_trainings, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingViewholder holder, int position) {
        holder.bind(trainingList.get(position));
    }

    @Override
    public int getItemCount() {
        return trainingList.size();
    }

    public void submitList(ArrayList<Training> trainings){
        trainingList.addAll(trainings);
        notifyDataSetChanged();
    }
}

class TrainingViewholder extends RecyclerView.ViewHolder{

    private final TextView tvTrainingType, tvSet, tvRepeat, tvDesc;

    public TrainingViewholder(@NonNull View itemView) {

        super(itemView);

        tvTrainingType = itemView.findViewById(R.id.tv_trainingType);
        tvSet = itemView.findViewById(R.id.tv_set);
        tvRepeat = itemView.findViewById(R.id.tv_repeat);
        tvDesc = itemView.findViewById(R.id.tv_desc);
    }

    public void bind(Training training){
        tvTrainingType.setText(training.getTrainingType());
        tvSet.setText(String.valueOf(training.getSet()));
        tvRepeat.setText(String.valueOf(training.getRepeat()));
        tvDesc.setText(training.getDescription());
    }
}