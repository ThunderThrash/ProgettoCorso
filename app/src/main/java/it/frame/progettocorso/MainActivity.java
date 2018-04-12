package it.frame.progettocorso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.button1)).setOnClickListener(v -> {

            String string = ((EditText) findViewById(R.id.editText1)).getText().toString();

            if(TextUtils.isEmpty(string)){

                Toast.makeText(getBaseContext(), R.string.message_toast, Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(getBaseContext(), string, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if( item.getItemId() == R.id.action_settings){

            // Toast.makeText(this, R.string.click_settings, Toast.LENGTH_SHORT).show();

            startActivity( new Intent(this, SettingsActivity.class) );
        }

        return super.onOptionsItemSelected(item);
    }
}
