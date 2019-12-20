package com.wulianwang.lsp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import android.content.Intent;
import android.view.View;
import android.widget.Button;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.wulianwang.lsp.R;

import java.util.Calendar;

public class PersonPublishActivity extends AppCompatActivity {
    private ListPopupWindow listPopupWindow = null;
    private ImageView arrowImageView;
    private TextView chooseText;
    private LinearLayout linearLayout;
    private Button mBtnTextView;
    TextView txt1;
    Button btn2,btn1,btn3,btn4 ,btn9,BtnTextView;
    ImageButton btn8;
    ImageView btn5;
    int mYear, mMonth, mDay;

    TextView date;
    final int DATE_DIALOG = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_person_publish);
        btn8= (ImageButton)findViewById(R.id.button2);
        date= (TextView) findViewById(R.id.date);
        //btn3=(Button)findViewById(R.id.button003);
        btn4=(Button)findViewById(R.id.button4);

        ImageView btn5 = (ImageView)this.findViewById(R.id.button5);
       btn5.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {

             finish();
            }
      });

        //btn5=(ImageView)findViewById(R.id.button5);
        //btn5.setOnClickListener(new View.OnClickListener() {

         // @Override
          //public void onClick(View v) {


              // Intent intent= new Intent(PersonPublishActivity.this,MapSearchActivity.class);
              // startActivity(intent);

         //  }});
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(PersonPublishActivity.this,MapSearchActivity.class);

                startActivity(intent);
            }
        });
        BtnTextView =findViewById(R.id.button1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        BtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(PersonPublishActivity.this,MapSearchActivity.class);

                startActivity(intent);
            }
        });
        txt1=(TextView)findViewById(R.id.sj);
        // txt2=(TextView)findViewById(R.id.text002);
        // btn1.setOnClickListener(new mClick());
        String[] ctype = new String[]{"请选择工作类型", "游戏", "电影", "娱乐", "图书"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ctype);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = super.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG);
            } });
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH); }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay); }
        return null; }

    public void display() {
        date.setText(new StringBuffer().append(mYear).append("-").

                append(mMonth + 1).append("-").append(mDay).append(" ")); }
    private DatePickerDialog.OnDateSetListener
            mdateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) { mYear = year; mMonth = monthOfYear;
            mDay = dayOfMonth; display(); } };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
