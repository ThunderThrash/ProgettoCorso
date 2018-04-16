package it.frame.progettocorso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(v -> {

            EditText editText = findViewById(R.id.editText1);

            String string = editText.getText().toString();

            if(TextUtils.isEmpty(string)){

                editText.setError(getString(R.string.value_required));

            } else {

                editText.setError(null);

                closeKeyBoard();

                Toast.makeText(getBaseContext(), string, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button2).setOnClickListener(v -> {

            startActivity( new Intent(this, WebViewActivity.class) );
        });
    }

    private void closeKeyBoard() {

        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        if(imm!=null && getCurrentFocus()!=null) {

            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
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
