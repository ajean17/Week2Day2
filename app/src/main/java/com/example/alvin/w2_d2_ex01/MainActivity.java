package com.example.alvin.w2_d2_ex01;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyAppSettings";
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    EditText firstName;
    EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = (EditText) findViewById(R.id.et_firstName);
        lastName = (EditText) findViewById(R.id.et_lastName);

        settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = settings.edit();
        //Writing to Shared Preferences
        editor.putString("key","some value");
        editor.putString("first", "FIRST NAME");
        editor.putString("last", "LAST NAME");
        editor.commit(); //Saves the previous command

        String value = settings.getString("key","");
        Toast.makeText(this,value, Toast.LENGTH_SHORT).show();
    }

    public void saveNames(View view) {
        editor.putString("first",firstName.getText().toString());
        editor.putString("last", lastName.getText().toString());
        editor.commit();
        firstName.setText("");
        lastName.setText("");
    }

    public void readFirst(View view) {
        String value = settings.getString("first","");
        Toast.makeText(this,value, Toast.LENGTH_SHORT).show();
    }

    public void readLast(View view) {
        String value = settings.getString("last","");
        Toast.makeText(this,value, Toast.LENGTH_SHORT).show();
    }

    public void updateNames(View view) {
        String firstValue = settings.getString("first","");
        String lastValue = settings.getString("last","");
        firstName.setText(firstValue);
        lastName.setText(lastValue);
    }
}
