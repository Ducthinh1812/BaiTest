package com.example.myapplication;

import static com.example.myapplication.MainActivity2.dates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.example.myapplication.databse.data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<model> list;
    adapter adapters;
    RecyclerView view;
    FloatingActionButton floats;
    CalendarView calendarView;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView =findViewById(R.id.calen);
        view=findViewById(R.id.recle);
        floats=findViewById(R.id.floatingActionButton);
        list=new ArrayList<>();
            view.setLayoutManager(new LinearLayoutManager(this));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
            view.addItemDecoration(dividerItemDecoration);
            adapters = new adapter(list,this);
            view.setAdapter(adapters);
            data db = data.getins(this.getApplicationContext());
            list = (ArrayList<model>) db.userDao().list();
            adapters.setadp(list);
            adapters.notifyDataSetChanged();
            floats.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplication(),MainActivity2.class);
               startActivity(intent);
           }
       });
       calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
               Calendar calendar=Calendar.getInstance();
               calendar.set(Calendar.YEAR,i);
               calendar.set(Calendar.MONTH,i1);
               calendar.set(Calendar.DAY_OF_MONTH,i2);
               SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd/MM/yyyy");
               date=simpleDateFormat1.format(calendar.getTime());
               list=new ArrayList<>();
               Log.e(String.valueOf(dates),"edddd");
               list=data.getins(MainActivity.this).userDao().calender(date);
               adapters.setadp(list);

           }
       });
    }
}