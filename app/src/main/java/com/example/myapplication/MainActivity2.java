package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.databse.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity2 extends AppCompatActivity {
    EditText edtnames,edtghichus,edtngaygios,edtmaus;
    Button btn,btn1;
    public static String dates;
   public static int DefaultColor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtnames=findViewById(R.id.edtname);
        edtghichus=findViewById(R.id.edtghichu);
        edtngaygios=findViewById(R.id.edtdatetime);
        edtmaus=findViewById(R.id.edtcolor);
        btn=findViewById(R.id.btnadd);
        btn1=findViewById(R.id.btnexit);
        DefaultColor= ContextCompat.getColor(MainActivity2.this, com.google.android.material.R.color.design_default_color_primary);
        edtmaus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencolor();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });
        edtngaygios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time();
            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });

    }
    public void add(){
        String name=edtnames.getText().toString().trim();
        String ngayh=edtngaygios.getText().toString().trim();
        String ghichu=edtghichus.getText().toString().trim();
        String mau=edtmaus.getText().toString().trim();
        model md=new model(name,ngayh,ghichu,mau);
        data.getins(this).userDao().inserttable(md);
        edtnames.setText("");
        edtngaygios.setText("");
        edtghichus.setText("");
        edtmaus.setText("");
    }
    public void time(){
        Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener datePickerDialog=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
              calendar.set(Calendar.YEAR,i);
              calendar.set(Calendar.MONTH,i1);
              calendar.set(Calendar.DAY_OF_MONTH,i2);
                TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        calendar.set(Calendar.HOUR,i);
                        calendar.set(Calendar.MINUTE,i1);
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy HH:mm");
//                        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("dd/MM/yyyy");
//                        dates=simpleDateFormat1.format(calendar.getTime());
                        edtngaygios.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new TimePickerDialog(MainActivity2.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };
        new DatePickerDialog(this,datePickerDialog,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void opencolor(){
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(MainActivity2.this, DefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog ambilWarnaDialog, int color) {

                DefaultColor = color;

                edtmaus.setText(""+DefaultColor);
            }

            @Override
            public void onCancel(AmbilWarnaDialog ambilWarnaDialog) {

            }
        });
        ambilWarnaDialog.show();
}
}