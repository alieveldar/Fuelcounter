package com.aliev.fuelcounter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatabaseFill dbFill = new DatabaseFill();
    EditText editText;
    DatePicker datePicker;
    Button buttonAdd;
    TextView deadlitres;
    int fuel;
    int day;
    int month;
    int year;
    int deadLineMonth;
    Context mcontext;
    ReadBase dbRead;
    Cursor readCursor;
    DeadLineLitres mdeadLineLitres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdeadLineLitres = new DeadLineLitres();
        dbRead = new ReadBase();
        editText = (EditText) findViewById(R.id.add_fuel);
        datePicker = (DatePicker) findViewById(R.id.data_fuel_calendar);
        buttonAdd = (Button) findViewById(R.id.add_data_button);
        //deadlitres = (TextView)findViewById(R.id.dead_litres);
        mcontext = getApplicationContext();
        readCursor = dbRead.readBase(mcontext);
        deadLineMonth = datePicker.getMonth();
        //setDeadLitres();


        View.OnClickListener button_add = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString() == "") {
                    fuel = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                    day = datePicker.getDayOfMonth();
                    month = datePicker.getMonth();
                    year = datePicker.getYear();
                    Log.d("OUT", fuel + " " + day);
                    Context context = getApplicationContext();
                    dbFill.fillBase(context, fuel, day, month, year);
                    setDeadLitres();
                } else
                {
                    setDeadLitres();
                }
            }
        };
        buttonAdd.setOnClickListener(button_add);


    }
    public void setDeadLitres(){


    }

}
