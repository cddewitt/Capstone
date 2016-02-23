package com.example.cdoit.characterstrengthbuilder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class LoginScreen extends AppCompatActivity {
    private SQLiteDatabase db;
    private String username;
    private String password;
    private EditText passwordField;
    private EditText usernameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        Button login = (Button) findViewById(R.id.loginButton);
        Button register = (Button) findViewById(R.id.registerButton);
        usernameField = (EditText) findViewById(R.id.usernameField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        DatabaseHelper helper = new DatabaseHelper(this);
        db = helper.getWritableDatabase();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void register() {
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        int idNumber = createIdNumber();
        String registerQuery = "INSERT INTO Users VALUES ('" + idNumber + "','" + username + "','" + password + "')";
        try {
            db.execSQL(registerQuery);
            Toast.makeText(LoginScreen.this, "You have successfully registered.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(LoginScreen.this, "Sorry, there was an issue.", Toast.LENGTH_SHORT).show();
        }
    }

    private int createIdNumber() {
        Random ran = new Random();
        return ran.nextInt(100000);
    }

    String dbPassword;

    private void login() {
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        boolean isMatch = false;
        String loginQuery = "SELECT Password FROM Users WHERE Username = \"" + username + "\"";
        Cursor cursor = db.rawQuery(loginQuery, null);
        if (cursor.moveToFirst()) {
            do {
                dbPassword = cursor.getString(0);
                isMatch = checkPasswordsMatch(cursor.getString(0));
            } while (cursor.moveToNext());
            cursor.close();
        } else {
            Toast.makeText(LoginScreen.this, "Username does not exist.", Toast.LENGTH_SHORT).show();
        }
        if (isMatch) {
            Toast.makeText(LoginScreen.this, "Great!", Toast.LENGTH_SHORT).show();
            //go to next screen
        } else {
            Toast.makeText(LoginScreen.this, "Password was incorrect.", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean checkPasswordsMatch(String dbPassword) {
        return dbPassword.equals(password);
    }

}
