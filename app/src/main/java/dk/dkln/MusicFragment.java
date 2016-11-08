package dk.dkln;

import android.os.Bundle;

/**
 * Created by dk on 2016/11/8.
 */

public class MusicFragment extends BaseFragment {


    public static MusicFragment newInstance() {

        Bundle args = new Bundle();

        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
