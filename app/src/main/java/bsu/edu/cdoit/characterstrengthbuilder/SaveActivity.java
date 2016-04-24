package bsu.edu.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Character Strength Builder");
        setContentView(R.layout.grip_save);
    }

    public void returnToHomeButtonClick(View v) {
        Log.v("Save", "in click");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
