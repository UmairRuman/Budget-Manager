package com.project.budgetmanager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


public class SavingFragment extends Fragment {



    TextView tvR, tvPython, tvCPP, tvJava;
    PieChart pieChart;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_saving, container, false);
        tvR = rootView.findViewById(R.id.tvMedical);
        tvPython = rootView.findViewById(R.id.tvEducation);
        tvCPP = rootView.findViewById(R.id.tvFun);
        tvJava = rootView.findViewById(R.id.tvFood);
        pieChart = rootView.findViewById(R.id.piechart);
        setData();
        return rootView;

    }
    private void setData()
    {

        // Set the percentage of language used
        tvR.setText(Integer.toString(10));
        tvPython.setText(Integer.toString(30));
        tvCPP.setText(Integer.toString(45));
        tvJava.setText(Integer.toString(25));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "Medical",
                        Integer.parseInt(tvR.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Python",
                        Integer.parseInt(tvPython.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "C++",
                        Integer.parseInt(tvCPP.getText().toString()),
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Java",
                        Integer.parseInt(tvJava.getText().toString()),
                        Color.parseColor("#29B6F6")));

        // To animate the pie chart
        pieChart.startAnimation();
    }
}