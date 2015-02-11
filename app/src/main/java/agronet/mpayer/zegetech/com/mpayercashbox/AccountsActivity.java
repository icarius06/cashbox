package agronet.mpayer.zegetech.com.mpayercashbox;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class AccountsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.action_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        TextView mTitle = (TextView) findViewById(R.id.accounts_title);
        mTitle.setTextColor(getResources().getColor(R.color.white));
        Typeface face = Typeface.createFromAsset(getApplicationContext().getAssets(), String.format("fonts/roboto_extralight.ttf"));
        mTitle.setTypeface(face);
        mTitle.setTextSize(30);
        mTitle.setText("Accounts");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accounts, menu);
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
}
