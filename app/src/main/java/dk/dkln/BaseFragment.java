package dk.dkln;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by dk on 2016/11/8.
 */

public class BaseFragment extends Fragment {



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initEvent();
        initView();
    }

    public void initView() {
    }

    public void initEvent() {
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
