package com.aliev.fuelcounter;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatabaseFill dbFill = new DatabaseFill();
    EditText editText;
    TextView capacity;
    Button buttonAdd;
    int fuel;
    SimpleCursorAdapter sca;
    ListView listFueling;
    int deadLineMonth;
    Context mcontext;

    ReadBase dbRead;
    Cursor readCursor;
    DeadLineLitres mdeadLineLitres;
    Calendar calendar = Calendar.getInstance();
    int bday = calendar.get(Calendar.DAY_OF_MONTH);
    int bmonth = calendar.get(Calendar.MONTH);
    int byear = calendar.get(Calendar.YEAR);
    int sday;
    int smonth;
    int syear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbRead = new ReadBase();
        mcontext = MainActivity.this;
        readCursor = dbRead.readBase(getApplicationContext());
        editText = (EditText)findViewById(R.id.add_fuel);
        capacity = (TextView)findViewById(R.id.capacity);
        String[] from = new String[] {FeedReaderContract.FeedEntry.COLUMN_DATE_DAY , FeedReaderContract.FeedEntry.COLUMN_NAME_MONTH, FeedReaderContract.FeedEntry.COLUMN_LiTRES};
        int[] to = new int[] {R.id.data_text_view, R.id.data_month_textview, R.id.capacity_text_view};

        sca = new SimpleCursorAdapter(this, R.layout.item, readCursor,from, to);

        listFueling = (ListView)findViewById(R.id.month_fuels_list);
        listFueling.setAdapter(sca);
        setCapaciry();
        DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                sday = dayOfMonth;
                smonth = month;
                syear = year;
                addToBase();
                readCursor.requery();
                sca.notifyDataSetChanged();
                setCapaciry();
            }
        };

        final DatePickerDialog  mdatePuckerDialog = new DatePickerDialog(mcontext, mdateListener, byear, bmonth, bday);
        buttonAdd = (Button)findViewById(R.id.add_data_button);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().matches("")) {
                    Toast tst = Toast.makeText(mcontext, R.string.enter_Fuel, Toast.LENGTH_LONG);
                        tst.show();
            }else{
                    fuel = Integer.parseInt(editText.getText().toString());
                    mdatePuckerDialog.show();





                }
                editText.setText("");
            }
        });




    }
    private void setCapaciry(){

       // readCursor.moveToFirst();
        //for (int x = 0; x < readCursor.getCount(); x++ ){
          //  icapacity = icapacity + readCursor.getInt(readCursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_LiTRES));
           // readCursor.moveToNext();
        //}
        //capacity.setText(String.valueOf(icapacity));
        DeadLineLitres currentMonthLitres = new DeadLineLitres();

        capacity.setText(currentMonthLitres.DeadLineLitres(readCursor, bmonth) );
    }
   private void addToBase(){

        dbFill.fillBase(mcontext, fuel, sday, smonth, syear);
   }
}