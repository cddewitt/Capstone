package com.example.cdoit.characterstrengthbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cory on 2/8/2016.
 */
public class WishActivity extends AppCompatActivity{

    private TextView tbxWish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Wish");
        setContentView(R.layout.woop_wish);
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

    public void btnWishClick(View v){
        tbxWish=(TextView)findViewById(R.id.wishEditText);
        String wish = tbxWish.getText().toString();
        if(wish.equals(""))
        {
            Toast toast =Toast.makeText(getApplicationContext(),"Please enter a wish before continuing",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Intent intent = new Intent(this, OutcomeActivity.class);
            intent.putExtra("Wish", tbxWish.getText().toString());
            startActivity(intent);
        }
    }
}



