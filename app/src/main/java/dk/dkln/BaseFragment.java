package dk.dkln;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by dk on 2016/11/8.
 */

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Base" , getClass().getSimpleName());
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    protected void startThActivityByIntent(Intent pIntent){
        startActivity(pIntent);
        getActivity().overridePendingTransition(R.anim.trans_next_in, R.anim.trans_next_out);
    }

}
