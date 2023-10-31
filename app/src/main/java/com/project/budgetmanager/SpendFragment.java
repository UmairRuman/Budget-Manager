package com.project.budgetmanager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

public class SpendFragment extends Fragment {
    MaterialToolbar topMaterialToolBar;
    TextView tvRemainingBalance,tvExpenseOutput,tvBudgetOutput,tvListHeading;
    RecyclerView rvSpending;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_spend, container, false);
        topMaterialToolBar=view.findViewById(R.id.spendingFragmentTopMaterialTollBar);
        tvRemainingBalance=view.findViewById(R.id.tvShowBalance);
        tvExpenseOutput=view.findViewById(R.id.tvShowExpenseOutput);
        tvBudgetOutput=view.findViewById(R.id.tvShowBudgetOutput);
        tvListHeading=view.findViewById(R.id.tvListHeading);
        rvSpending=view.findViewById(R.id.rvSpendingFragment);
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
    }
}