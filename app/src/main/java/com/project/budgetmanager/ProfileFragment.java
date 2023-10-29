package com.project.budgetmanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class ProfileFragment extends Fragment {
    AppCompatButton btnReminder,btnProfileSettings,btnGeneralSettings,btnBudgetHistory,btnFeedBack;
    Intent intentReminder =new Intent(getActivity().getApplication(), ReminderActivity.class);
    Intent intentProfileSettings =new Intent(getActivity().getApplication(), ProfileSettingsActivity.class);
    Intent intentGeneralSettings =new Intent(getActivity().getApplication(), GeneralSettingsActivity.class);
    Intent intentBudgetHistory =new Intent(getActivity().getApplication(), BudgetHistoryActivity.class);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        //Define Your Ids Here
        btnReminder = view.findViewById(R.id.btnReminder);
        btnProfileSettings = view.findViewById(R.id.btnProfileSettings);
        btnGeneralSettings = view.findViewById(R.id.btnGeneralSettings);
        btnBudgetHistory = view.findViewById(R.id.btnBudgetHistory);
        btnFeedBack = view.findViewById(R.id.btnFeedBack);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //if you want to do something related to the main activity do it here
    }

    @Override
    public void onResume() {
        super.onResume();
        // do all the work here set ur recycler view etc.

        //Reminder Button
        btnReminder.setOnClickListener(view -> startActivity(intentReminder));
        //Profile Settings Button
        btnProfileSettings.setOnClickListener(v -> startActivity(intentProfileSettings));
        //General Settings Button
        btnGeneralSettings.setOnClickListener(v -> startActivity(intentGeneralSettings));
        //Budget History Button
        btnBudgetHistory.setOnClickListener(v -> startActivity(intentBudgetHistory));
    }
}