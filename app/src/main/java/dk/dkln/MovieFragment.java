package dk.dkln;

import android.os.Bundle;

/**
 * Created by dk on 2016/11/8.
 */

public class MovieFragment extends BaseFragment {


    public static MovieFragment newInstance() {

        Bundle args = new Bundle();

        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
