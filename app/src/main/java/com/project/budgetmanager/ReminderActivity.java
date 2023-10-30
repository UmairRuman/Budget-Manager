package com.project.budgetmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

public class ReminderActivity extends AppCompatActivity {

     EditText etTitle,etDescription;
     TextView tvTimeShow;
     Button btnReminder;
     ImageView ivClock;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
       etTitle=findViewById(R.id.etTitle);
       etDescription=findViewById(R.id.etDescription);
       tvTimeShow=findViewById(R.id.tvTimePicker);
       btnReminder=findViewById(R.id.btnSetReminder);
       ivClock=findViewById(R.id.ivClock);

       //Time Picker Of Reminder
       ivClock.setOnClickListener(new View.OnClickListener() {
           Long BeginTime,EndTime;
           @Override
           public void onClick(View view) {
               MaterialTimePicker picker=new MaterialTimePicker.Builder()
                       .setTimeFormat(TimeFormat.CLOCK_12H)
//                       .setHour(12)
//                       .setMinute(59)
                       .setTitleText("InterView Time")
                       .build();
               picker.show(getSupportFragmentManager(),"time");
               picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                   @SuppressLint("SetTextI18n")
                   @Override
                   public void onClick(View view) {
                       if (picker.getHour()<=12){
                           tvTimeShow.setText(picker.getHour()+ " " + ":" +picker.getMinute()+ " ");
                           BeginTime=(long) picker.getHour()*60*60*1000;
                       }else {
                           tvTimeShow.setText(picker.getHour()-12+":"+picker.getMinute());
                           BeginTime=(long) picker.getHour()*60*60*1000;
                       }
                   }
               });
           }
       });

    }
}