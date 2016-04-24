package bsu.edu.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by cdoit on 11/16/2015.
 */
public class AnalysisActivity extends AppCompatActivity {
    private String characterString = "";
    private String[] analysisList = {"grit", "selfAnalysis", "communicationSkills", "zest", "gratitude", "optimism", "curiosity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Analysis");
        setContentView(R.layout.analysis);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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


    public void btnGritClick(View v) {
        Intent intent = new Intent(this, LineGraph.class);
        switch(v.getId()) {
            case (R.id.btnGrit):
                intent.putExtra("Analysis", analysisList[0]);
                break;
            case (R.id.btnSelfAnalysis):
                intent.putExtra("Analysis", analysisList[1]);
                break;
            case (R.id.btnCommunicationSkills):
                intent.putExtra("Analysis", analysisList[2]);
                break;
            case (R.id.btnZest):
                intent.putExtra("Analysis", analysisList[3]);
                break;
            case (R.id.btnGratitude):
                intent.putExtra("Analysis", analysisList[4]);
                break;
            case (R.id.btnOptimism):
                intent.putExtra("Analysis", analysisList[5]);
                break;
            case (R.id.btnCuriosity):
                intent.putExtra("Analysis", analysisList[6]);
                break;
        }
        startActivity(intent);
    }
}
