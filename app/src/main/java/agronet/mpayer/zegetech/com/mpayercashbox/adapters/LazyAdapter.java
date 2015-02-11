package agronet.mpayer.zegetech.com.mpayercashbox.adapters;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import agronet.mpayer.zegetech.com.mpayercashbox.R;
import agronet.mpayer.zegetech.com.mpayercashbox.utils.Constants;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;

    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView memberName = (TextView)vi.findViewById(R.id.title); // title
        memberName.setTypeface(Constants.getCustomFace(activity, "Roboto"));

        TextView id = (TextView)vi.findViewById(R.id.artist); // artist name
        id.setTypeface(Constants.getCustomFace(activity, "Roboto"));

        TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
        
        HashMap<String, String> member = new HashMap<String, String>();
        member = data.get(position);
        
        // Setting all values in listview
        memberName.setText(member.get("name"));
        id.setText(member.get("id"));
        duration.setText("Duration");

        return vi;
    }
}