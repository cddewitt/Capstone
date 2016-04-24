package bsu.edu.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GritTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Back When Done to Set Score");
        setContentView(R.layout.grit_test);
    }

    public void continueToGritTestButtonClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sasupenn.qualtrics.com/jfe/form/SV_06f6QSOS2pZW9qR"));
        startActivity(intent);
    }

}
