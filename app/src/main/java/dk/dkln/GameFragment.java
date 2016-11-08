package dk.dkln;

import android.os.Bundle;

/**
 * Created by dk on 2016/11/8.
 */

public class GameFragment extends BaseFragment {

    public static GameFragment newInstance() {

        Bundle args = new Bundle();

        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
