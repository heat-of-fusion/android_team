package com.example.androidteamproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView textview;
    EditText editText;
    Button button1;
    Button button2;
    Button button3;

    Map<Integer, String> jan = new HashMap<Integer, String>();
    Map<Integer, String> fab = new HashMap<Integer, String>();
    Map<Integer, String> mar = new HashMap<Integer, String>();
    Map<Integer, String> apr = new HashMap<Integer, String>();
    Map<Integer, String> may = new HashMap<Integer, String>();
    Map<Integer, String> jun = new HashMap<Integer, String>();
    Map<Integer, String> jul = new HashMap<Integer, String>();
    Map<Integer, String> aug = new HashMap<Integer, String>();
    Map<Integer, String> sep = new HashMap<Integer, String>();
    Map<Integer, String> oct = new HashMap<Integer, String>();
    Map<Integer, String> nov = new HashMap<Integer, String>();
    Map<Integer, String> dec = new HashMap<Integer, String>();

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);
        textview = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        sp = getSharedPreferences("myFile", Activity.MODE_PRIVATE);

        for(int i = 0; i < 32; i++) {
            String spText = "jan" + i;
            jan.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 29; i++) {
            String spText = "fab" + i;
            fab.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 32; i++) {
            String spText = "mar" + i;
            mar.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 31; i++) {
            String spText = "apr" + i;
            apr.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 32; i++) {
            String spText = "may" + i;
            may.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 31; i++) {
            String spText = "jun" + i;
            jan.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 32; i++) {
            String spText = "jul" + i;
            jul.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 32; i++) {
            String spText = "aug" + i;
            aug.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 31; i++) {
            String spText = "sep" + i;
            sep.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 32; i++) {
            String spText = "oct" + i;
            oct.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 31; i++) {
            String spText = "nov" + i;
            nov.put(i, sp.getString(spText, ""));
        }
        for(int i = 0; i < 32; i++) {
            String spText = "dec" + i;
            dec.put(i, sp.getString(spText, ""));
        }

        String monthList[] = {"jan", "fab", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};

//        for(String i : monthList) {
//            switch(i) {
//                case "jan":
//                    setArray(i, 1);
//                    break;
//                case "fab":
//                    setArray(i, 2);
//                    break;
//                case "mar":
//                    setArray(i, 3);
//                    break;
//                case "apr":
//                    setArray(i, 4);
//                    break;
//                case "may":
//                    setArray(i, 5);
//                    break;
//                case "jun":
//                    setArray(i, 6);
//                    break;
//                case "jul":
//                    setArray(i, 7);
//                    break;
//                case "aug":
//                    setArray(i, 8);
//                    break;
//                case "sep":
//                    setArray(i, 9);
//                    break;
//                case "oct":
//                    setArray(i, 10);
//                    break;
//                case "nov":
//                    setArray(i, 11);
//                    break;
//                case "dec":
//                    setArray(i, 12);
//                    break;
//            }
//        }

        for (int i = 1; i < 13; i++) {
            setArray(i);
        }

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, final int month, final int dayOfMonth) {
                editText.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                textview.setText(findText(month, dayOfMonth));
                button1.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String todo = editText.getText().toString();
                        setTodo(month, dayOfMonth, todo);
                        Toast.makeText(getApplicationContext(),"일정이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                button2.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(getApplicationContext(),"아직 개발이 안되었습니다.", Toast.LENGTH_SHORT).show();
//                        return;

//                        String todoText = textview.getText().toString();
//                        textview.setText(todoText + "(완료)");

                        addFinsihed(month, dayOfMonth);
                        Toast.makeText(getApplicationContext(), "일정이 완료처리되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                button3.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setTodo(month, dayOfMonth, "");
                        Toast.makeText(getApplicationContext(),"일정이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                for (int i = 1; i < 13; i++) {
                    setArray(i);
                }
            }
        });


    }

    public void setTodo(int month, int dayOfMonth, String todo) {
        switch(month) {
            case 1:
                jan.put(dayOfMonth, todo);
                break;
            case 2:
                fab.put(dayOfMonth, todo);
                break;
            case 3:
                mar.put(dayOfMonth, todo);
                break;
            case 4:
                apr.put(dayOfMonth, todo);
                break;
            case 5:
                may.put(dayOfMonth, todo);
                break;
            case 6:
                jun.put(dayOfMonth, todo);
                break;
            case 7:
                jul.put(dayOfMonth, todo);
                break;
            case 8:
                aug.put(dayOfMonth, todo);
                break;
            case 9:
                sep.put(dayOfMonth, todo);
                break;
            case 10:
                oct.put(dayOfMonth, todo);
                break;
            case 11:
                nov.put(dayOfMonth, todo);
                break;
            case 12:
                dec.put(dayOfMonth, todo);
                break;
        }
    }

    public String findText(int month, int dayOfMonth) {
        switch(month) {
            case 1:
                return jan.get(dayOfMonth);
            case 2:
                return fab.get(dayOfMonth);
            case 3:
                return mar.get(dayOfMonth);
            case 4:
                return apr.get(dayOfMonth);
            case 5:
                return may.get(dayOfMonth);
            case 6:
                return jun.get(dayOfMonth);
            case 7:
                return jul.get(dayOfMonth);
            case 8:
                return aug.get(dayOfMonth);
            case 9:
                return sep.get(dayOfMonth);
            case 10:
                return oct.get(dayOfMonth);
            case 11:
                return nov.get(dayOfMonth);
            case 12:
                return dec.get(dayOfMonth);
            default:
                return "";
        }
    }

    public void setArray(int key) {
        switch(key) {
            case 1:
                thirtyOne(jan, "jan");
                break;
            case 2:
                two(fab, "fab");
                break;
            case 3:
                thirtyOne(mar, "mar");
                break;
            case 4:
                thirty(apr, "apr");
                break;
            case 5:
                thirtyOne(may, "may");
                break;
            case 6:
                thirty(jun, "jun");
                break;
            case 7:
                thirtyOne(jul, "jul");
                break;
            case 8:
                thirtyOne(aug, "aug");
                break;
            case 9:
                thirty(sep, "sep");
                break;
            case 10:
                thirtyOne(oct, "oct");
                break;
            case 11:
                thirty(nov, "nov");
                break;
            case 12:
                thirtyOne(dec, "dec");
                break;

        }
    }

    public void thirtyOne(Map<Integer, String> month, String monthString) {
        SharedPreferences.Editor editor = sp.edit();
        for(int i = 1; i < 32; i++) {
            editor.putString(monthString + i, month.get(i));
            editor.commit();
        }
    }

    public void thirty(Map<Integer, String> month, String monthString) {
        SharedPreferences.Editor editor = sp.edit();
        for (int i = 1; i < 31; i++) {
            editor.putString(monthString + i, month.get(i));
            editor.commit();
        }

    }

    public void two(Map<Integer, String> month, String monthString) {
        SharedPreferences.Editor editor = sp.edit();
        for (int i = 0; i < 30; i++) {
            editor.putString(monthString + i, month.get(i));
            editor.commit();
        }
    }

    public void addFinsihed(int month, int day) {
        String alteredText;
        switch(month) {
            case 1:
                alteredText = jan.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 2:
                alteredText = fab.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 3:
                alteredText = mar.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 4:
                alteredText = apr.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 5:
                alteredText = may.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 6:
                alteredText = jun.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 7:
                alteredText = jul.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 8:
                alteredText = aug.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 9:
                alteredText = sep.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 10:
                alteredText = oct.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 11:
                alteredText = nov.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;
            case 12:
                alteredText = dec.get(day) + "(완료)";
                setTodo(month, day, alteredText);
                break;

        }
    }



}