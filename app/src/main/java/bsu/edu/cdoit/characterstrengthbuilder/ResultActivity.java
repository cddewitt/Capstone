package bsu.edu.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private TextView tbxResult;
    private String goal = "";
    private String characteristic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.grip_result);
        tbxResult = (TextView) findViewById(R.id.resultEditText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characteristic = extras.getString("Characteristic");
            goal = extras.getString("Goal");
        }
    }

    public void continueToObstacleButtonClick(View v) {
        String result = tbxResult.getText().toString();
        if (result.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please enter a possible result before continuing", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Intent intent = new Intent(this, InteferenceActivity.class);
            intent.putExtra("Characteristic", characteristic);
            intent.putExtra("Goal", goal);
            intent.putExtra("Result", result);
            startActivity(intent);
        }
    }


}
