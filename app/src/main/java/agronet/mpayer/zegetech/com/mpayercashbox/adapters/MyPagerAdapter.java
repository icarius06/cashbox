package agronet.mpayer.zegetech.com.mpayercashbox.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

import agronet.mpayer.zegetech.com.mpayercashbox.R;
import agronet.mpayer.zegetech.com.mpayercashbox.fragments.HomeMenuFragment;

/**
 * Created by Michael on 2/7/2015.
 */
public class MyPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    private final String[] TITLES = { "Home", "Settings" };

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getPageIconResId(int position) {
        int resId = 0;
        if(position==0){
            resId = R.drawable.home;
        }else{
            resId = R.drawable.settings;
        }
        return resId;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return HomeMenuFragment.newInstance(position);
    }
}