package agronet.mpayer.zegetech.com.mpayercashbox;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;

public class SelectedMemberActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_member);
        HashMap<String,String>member = (HashMap<String,String>)getIntent().getExtras().get("member");
        TextView toolbar_subtitle =(TextView)findViewById(R.id.toolbar_subtitle);
        toolbar_subtitle.setText(member.get("name"));
        TextView tv = (TextView)findViewById(R.id.member_name);
        tv.setText(member.get("name"));
        tv = (TextView)findViewById(R.id.member_email);
        tv.setText("Email Ad");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selected_member, menu);
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
