package dk.dkln.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import dk.dkln.MusicListFragment;

/**
 * Created by dk on 2016/11/14.
 */
public class MusicViewpagerAdapter extends FragmentStatePagerAdapter {


    private String[] mTitles;

    public MusicViewpagerAdapter(FragmentManager fm, String[] mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override public Fragment getItem(int position) {

        return MusicListFragment.newInstance(position,mTitles[position]);
    }

    @Override public int getCount() {
        return mTitles.length;
    }
}
