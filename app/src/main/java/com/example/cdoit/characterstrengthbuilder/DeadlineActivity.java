package com.example.cdoit.characterstrengthbuilder;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DeadlineActivity extends Activity {

    private static TextView tbxDate;
    private String characteristic = "";
    private String wish = "";
    private String outcome = "";
    private String obstacle = "";
    private String plan = "";
    private String today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.woop_deadline);
        final Calendar cal = Calendar.getInstance();
        tbxDate = (TextView) findViewById(R.id.tbxDate);
        today = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR);
        tbxDate.setText("DATE: " + today);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic = extras.getString("Characteristic");
            wish = extras.getString("Wish");
            outcome = extras.getString("Outcome");
            obstacle = extras.getString("Obstacle");
            plan = extras.getString("Plan");
        }
    }

    public void setDateButtonClick(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void reviewYourWoopButtonClick(View v) {
        String deadlineDate = tbxDate.getText().toString().replace("Date: ", "");

        Intent intent = new Intent(this, ReviewActivity.class);
        intent.putExtra("Characteristic", characteristic);
        intent.putExtra("Wish", wish);
        intent.putExtra("Outcome", outcome);
        intent.putExtra("Obstacle", obstacle);
        intent.putExtra("Plan", plan);
        if (!deadlineDate.equals(today)) {
            intent.putExtra("Deadline_Date", deadlineDate);
            Toast toast = Toast.makeText(this, "Is Not Today", Toast.LENGTH_LONG);
            toast.show();
        } else {
            intent.putExtra("Deadline_Date", DatabaseContract.NO_DATE);
        }
        startActivity(intent);
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        long date;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            final Calendar cal = Calendar.getInstance();

            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            tbxDate.setText("Date: " + (monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
        }
    }

}





