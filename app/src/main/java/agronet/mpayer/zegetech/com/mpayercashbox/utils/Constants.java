package agronet.mpayer.zegetech.com.mpayercashbox.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Michael on 2/6/2015.
 */
public class Constants {

    public static Typeface getCustomFace(Context c,String type){
        if (type.equals("Roboto")) {
            Typeface roboto = Typeface.createFromAsset(c.getAssets(), "fonts/roboto_light.ttf");
            return roboto;
        }
        else{
            Typeface open = Typeface.createFromAsset(c.getAssets(), "fonts/opensans_regular.ttf");
            return open;
        }
    }

}
