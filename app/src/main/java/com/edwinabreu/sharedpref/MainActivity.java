package com.edwinabreu.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String USER_INFO = "user_info";
    EditText username, password;
    TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        textOutput = (TextView) findViewById(R.id.text_output);

    }

    // Save the user login info.
    public void saveInfo(View view) {
        // This preferences won't be share to another application, it's private.
        SharedPreferences sharedPref = getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    // Display the user login info.
    public void displayInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);

        String username = sharedPref.getString("username", "");
        String password = sharedPref.getString("password", "");

        textOutput.setText(username + " - " + password);

    }
}
