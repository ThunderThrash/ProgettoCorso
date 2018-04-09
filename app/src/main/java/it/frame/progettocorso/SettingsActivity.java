package it.frame.progettocorso;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private TextView user_name;
    private Switch switch1;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user_name = findViewById(R.id.user_name);
        user_name.setOnClickListener( v -> showUsernameDialog() );

        switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {

            SharedPreferences sharedPrefs = getSharedPreferences(Constants.SETTINGS_STORAGE,MODE_PRIVATE);

            sharedPrefs.edit().putBoolean(Constants.NOTIFY_KEY, isChecked).commit();
        });

        spinner1 = findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> adapter, View view, int pos, long id) {

                SharedPreferences sharedPrefs = getSharedPreferences(Constants.SETTINGS_STORAGE,MODE_PRIVATE);

                sharedPrefs.edit().putInt(Constants.SPINNER_POS_KEY, pos).commit();
            }

            public void onNothingSelected(AdapterView<?> arg0) {}

        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        showSettings();
    }

    private void showSettings() {

        SharedPreferences sharedPrefs =
                getSharedPreferences(Constants.SETTINGS_STORAGE,MODE_PRIVATE);

        boolean notify = sharedPrefs.getBoolean(Constants.NOTIFY_KEY, false);
        switch1.setChecked(notify);

        String strUserName = sharedPrefs.getString(Constants.USERNAME_KEY, null);
        user_name.setText(strUserName);

        int spinnerPos =sharedPrefs.getInt(Constants.SPINNER_POS_KEY,0);
        spinner1.setSelection(spinnerPos);
    }

    private void showUsernameDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.pref_user_name);

        // Set up the input
        final EditText input = new EditText(this);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT );

        builder.setView(input);

        // Set up the ok buttons
        builder.setPositiveButton(R.string.ok, (dialog, which) -> {

            String strUserName = input.getText().toString();

            SharedPreferences sharedPrefs = getSharedPreferences(Constants.SETTINGS_STORAGE,MODE_PRIVATE);

            sharedPrefs.edit().putString(Constants.USERNAME_KEY, strUserName).commit();

            user_name.setText(strUserName);
        });

        // Set up the cancel buttons
        builder.setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());

        builder.show();
    }

}
