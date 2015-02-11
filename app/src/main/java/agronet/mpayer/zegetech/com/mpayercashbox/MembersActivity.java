package agronet.mpayer.zegetech.com.mpayercashbox;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import agronet.mpayer.zegetech.com.mpayercashbox.adapters.LazyAdapter;


public class MembersActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        Toolbar toolbar = (Toolbar) findViewById(R.id.action_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        TextView mTitle = (TextView) findViewById(R.id.members_title);
        mTitle.setTextColor(getResources().getColor(R.color.white));
        Typeface face = Typeface.createFromAsset(getApplicationContext().getAssets(), String.format("fonts/roboto_extralight.ttf"));
        mTitle.setTypeface(face);
        mTitle.setTextSize(30);
        mTitle.setText("Members");
       /* ListView list=(ListView)findViewById(R.id.list);

        ArrayList<HashMap<String,String>> data  = new ArrayList<HashMap<String, String>>();
        HashMap<String,String>person = new HashMap<String, String>();
        person.put("name","Andrew Munya");
        person.put("id","254713245463");
        data.add(person);

        person = new HashMap<String, String>();
        person.put("name","Bama Nabu");
        person.put("id","254720226253");
        data.add(person);

        person = new HashMap<String, String>();
        person.put("name","Berth Babu");
        person.put("id","beverage@karizshop.com");
        data.add(person);

        // Getting adapter by passing xml data ArrayList
        LazyAdapter adapter=new LazyAdapter(this, data);*/
        //list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_members, menu);
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
