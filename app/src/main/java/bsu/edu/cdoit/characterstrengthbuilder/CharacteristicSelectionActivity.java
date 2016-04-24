package bsu.edu.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CharacteristicSelectionActivity extends AppCompatActivity {

    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Characteristic");
        setContentView(R.layout.activity_characteristic_selection);
        rg = (RadioGroup)findViewById(R.id.radioCharacteristic);
    }

    public void btnCharacteristicToWishClick(View v) {
        Intent intent = new Intent(this, GoalActivity.class);
        int id = rg.getCheckedRadioButtonId();
        if(id==-1)
        {
            Toast toast = Toast.makeText(getApplicationContext(),"You must select a character strength before continuing.",Toast.LENGTH_LONG );
            toast.show();
        }
        else {
            RadioButton rb = (RadioButton) findViewById(id);
            intent.putExtra("Characteristic", rb.getText());
            startActivity(intent);
        }
    }
}
