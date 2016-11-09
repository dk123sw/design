package dk.dkln.mvp;

import android.os.Bundle;

import dk.dkln.BaseFragment;

/**
 * Created by dk on 2016/11/9.
 */

public class MovieLiveFragment extends BaseFragment {

    public static MovieLiveFragment newInstance() {

        Bundle args = new Bundle();
        MovieLiveFragment fragment = new MovieLiveFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
