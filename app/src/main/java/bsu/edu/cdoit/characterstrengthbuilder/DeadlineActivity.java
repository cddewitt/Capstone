package bsu.edu.cdoit.characterstrengthbuilder;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DeadlineActivity extends AppCompatActivity {

    private static TextView tbxDate;
    private String characteristic = "";
    private String goal = "";
    private String result = "";
    private String interferences = "";
    private String plans = "";
    private String today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.grip_deadline);
        final Calendar cal = Calendar.getInstance();
        tbxDate = (TextView) findViewById(R.id.tbxDate);
        today = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR);
        tbxDate.setText(tbxDate.getText() + today);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic = extras.getString("Characteristic");
            goal = extras.getString("Goal");
            result = extras.getString("Result");
            interferences = extras.getString("Interferences");
            plans = extras.getString("Plan");
        }
    }

    public void setDateButtonClick(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void reviewYourGripButtonClick(View v) {
        String deadlineDate = tbxDate.getText().toString().replace("Selected Date: ", "");

        Intent intent = new Intent(this, ReviewActivity.class);
        intent.putExtra("Characteristic", characteristic);
        intent.putExtra("Goal", goal);
        intent.putExtra("Result", result);
        intent.putExtra("Interferences", interferences);
        intent.putExtra("Plan", plans);
        if (!deadlineDate.equals(today)) {
            intent.putExtra("Deadline_Date", deadlineDate);
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

            tbxDate.setText("Selected Date: " + (monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
        }
    }

}





