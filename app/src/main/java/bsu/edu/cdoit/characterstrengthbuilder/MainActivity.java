package bsu.edu.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.main);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("MMM dd");
        String strDate = "Today, " + mdformat.format(calendar.getTime());

        currentDate = (TextView) findViewById(R.id.dateText);
        currentDate.setText(strDate);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnGoalClick(View v) {
        Intent intent = new Intent(this, GoalsActivity.class);
        startActivity(intent);
    }


    public void btnAnalysisClick(View v) {
        Intent intent = new Intent(this, AnalysisLinkActivity.class);
        startActivity(intent);
    }

    public void btnTheoryClick(View v) {
        Intent intent = new Intent(this, theoryActivity.class);
        startActivity(intent);
    }

    public void btnLovelyThinkingClick(View v) {
        Intent intent = new Intent(this, LovelyThinkingActivity.class);
        startActivity(intent);
    }
    public void btnDonateClick(View v) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://oki.wish.org/"));
        startActivity(implicit);

    }
}