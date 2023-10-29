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
    AppCompatButton btnNotify;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        //Define Your Ids Here
        btnNotify = view.findViewById(R.id.btnReminder);
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
        Intent intent=new Intent(getActivity().getApplication(), ReminderActivity.class);
   btnNotify.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
            startActivity(intent);
         }
     });




  
    }
}