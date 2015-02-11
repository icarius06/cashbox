package agronet.mpayer.zegetech.com.mpayercashbox;

import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import agronet.mpayer.zegetech.com.mpayercashbox.adapters.LazyAdapter;

public class MembersActivity extends ActionBarActivity {

    private ArrayList<HashMap<String,String>> mAppList= new ArrayList<HashMap<String, String>>();
    AppAdapter mAdapter;

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
        SwipeMenuListView listView=(SwipeMenuListView)findViewById(R.id.listView);

        mAdapter = new AppAdapter();
        listView.setAdapter(mAdapter);

        HashMap<String,String>person = new HashMap<String, String>();
        person.put("name","Andrew Munya");
        person.put("id","254713245463");
        mAppList.add(person);

        person = new HashMap<String, String>();
        person.put("name","Bama Nabu");
        person.put("id","254720226253");
        mAppList.add(person);

        person = new HashMap<String, String>();
        person.put("name","Berth Babu");
        person.put("id","beverage@karizshop.com");
        mAppList.add(person);

        person = new HashMap<String, String>();
        person.put("name","Angelous Kamande");
        person.put("id","254788485");
        mAppList.add(person);

        // Getting adapter by passing xml data ArrayList
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(R.color.primaryColor);
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Top Up");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(R.color.pink);
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_close);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

// set creator
        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        Toast.makeText(MembersActivity.this,"Open",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MembersActivity.this,"Delete",Toast.LENGTH_SHORT).show();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MembersActivity.this,"Open selected item",Toast.LENGTH_SHORT).show();
            }
        });
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

    class AppAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mAppList.size();
        }

        @Override
        public HashMap<String,String> getItem(int position) {
            return mAppList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(),
                        R.layout.item_list_app, null);
                new ViewHolder(convertView);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            HashMap<String,String> item = getItem(position);
            holder.iv_icon.setImageDrawable(getResources().getDrawable(R.drawable.ic_person));
            holder.tv_name.setText(item.get("name"));
            holder.id_name.setText(item.get("id"));
            return convertView;
        }

        class ViewHolder {
            ImageView iv_icon;
            TextView tv_name;
            TextView id_name;

            public ViewHolder(View view) {
                iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                tv_name = (TextView) view.findViewById(R.id.tv_name);
                Typeface face = Typeface.createFromAsset(getApplicationContext().getAssets(), String.format("fonts/roboto_extralight.ttf"));
                tv_name.setTypeface(face);

                id_name = (TextView) view.findViewById(R.id.id_name);
                view.setTag(this);
            }
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
