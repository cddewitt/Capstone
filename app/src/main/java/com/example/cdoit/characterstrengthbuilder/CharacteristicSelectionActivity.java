package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CharacteristicSelectionActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Characteristic");
        setContentView(R.layout.activity_characteristic_selection);
        spinner = (Spinner) findViewById(R.id.spinnerCharacteristics);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.characteristics_array, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void btnCharacteristicToWishClick(View v) {
        Intent intent = new Intent(this, GoalActivity.class);
        intent.putExtra("Characteristic", spinner.getSelectedItem().toString());
        startActivity(intent);
    }
}
