package com.project.budgetmanager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class SpendFragment extends Fragment {
    MaterialToolbar topMaterialToolBar;
    TextView tvRemainingBalance,tvExpenseOutput,tvBudgetOutput,tvListHeading;
    RecyclerView rvSpending;
    CatalogAdapter adapter;
    private boolean isOpenedFirstTime=false;

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
    }


    @Override
    public void onResume() {
        super.onResume();
        adapter=new CatalogAdapter(DummyCatalogData.generateDailyCatalogData());
            topMaterialToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId()==R.id.tvMenuDailyCatalogs){
                        //Show daily catalogs by updating the recycler view
                        adapter=new CatalogAdapter(DummyCatalogData.generateDailyCatalogData());
                        updateRecyclerView(adapter);
                        tvListHeading.setText(getString(R.string.tvItemDaily));
                        Toast.makeText(getContext(), "daily", Toast.LENGTH_SHORT).show();
                        return  true;
                    }else if (item.getItemId()==R.id.tvMenuWeeklyCatalogs) {
                          //Show weekly catalogs by updating the recycler view
                          adapter=new CatalogAdapter(DummyCatalogData.generateWeeklyCatalogData());
                          updateRecyclerView(adapter);
                        tvListHeading.setText(getString(R.string.tvItemWeekly));
                        Toast.makeText(getContext(), "weekly", Toast.LENGTH_SHORT).show();
                        return  true;
                    }else if (item.getItemId()==R.id.tvMenuMonthlyCatalogs){
                        //Show monthly catalogs by updating the recycler view
                        adapter=new CatalogAdapter(DummyCatalogData.generateMonthlyCatalogData());
                        updateRecyclerView(adapter);
                        tvListHeading.setText(getString(R.string.tvItemMonthly));
                        Toast.makeText(getContext(), "monthly", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    return false;
                }
            });
            adapter.setCatalogClickListener(new CatalogAdapter.OnCatalogClickListener() {
                @Override
                public void onSingleClick(View view, int position) {
                    //Show the edit dialog
                }

                @Override
                public void onLongClick(View view, int position) {
                 //show the delete dialog
                }
            });


    }
    //Method for updating recycler view
    private void updateRecyclerView(CatalogAdapter adapter){
        rvSpending.setAdapter(adapter);
        rvSpending.setHasFixedSize(true);
        rvSpending.setLayoutManager(new LinearLayoutManager(getContext()));
    }
    //Ui ko responsive krna hay aur jis category pr click honay ka ame list heading mei de dena hay
}