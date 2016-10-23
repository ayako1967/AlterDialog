package jp.techacademy.takuya.okitsu.alterdialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            mTextView.setText(mEditText.getText().toString());
        } else if (v.getId() == R.id.button2) {
            showAlterDialog();
        } else if (v.getId() == R.id.button3) {
            showTimePickerDialog();
        } else if (v.getId() == R.id.button4) {
            showDatePickDialog();
        }
    }

    private void showAlterDialog() {
        AlertDialog.Builder alterDialogBuilder = new AlertDialog.Builder(this);
        alterDialogBuilder.setTitle("タイトル");
        alterDialogBuilder.setMessage("メッセージ");

        alterDialogBuilder.setPositiveButton("肯定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int witch) {
                        Log.d("UI_PARTS", "肯定ボタン");
                    }


                });
        alterDialogBuilder.setNeutralButton("中立",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int witch) {
                        Log.d("UI_PARTS", "中立ボタン");
                    }


                });
        alterDialogBuilder.setNegativeButton("否定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int witch) {
                        Log.d("UI_PARTS", "否定ボタン");
                    }


                });
        AlertDialog alterDialog = alterDialogBuilder.create();
        alterDialog.show();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view,int hourOfDay,int minute) {
                    Log.d("UI-PARTS",String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                }
                },13,0,true);
        timePickerDialog.show();
    }

    private void showDatePickDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth) {
                Log.d("UI-PARTS",String.valueOf(year) + "/" + String.valueOf(monthOfYear) + "/" +
                String.valueOf(dayOfMonth));
            }
        },2016,6,1
        );
        datePickerDialog.show();
    }
}