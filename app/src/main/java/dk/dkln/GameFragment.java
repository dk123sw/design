package dk.dkln;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dk.dkln.calculator.Calculator;
import dk.dkln.game_2048.GameActivity;

/**
 * Created by dk on 2016/11/8.
 */

public class GameFragment extends BaseFragment {

    Intent intent;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this ,view);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_game_list ,container ,false);
        return view;
    }

    public static GameFragment newInstance() {

        Bundle args = new Bundle();

        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.zxing , R.id.calculator ,R.id.game})
    public void  OnClick(View view){
        switch (view.getId()){
//            case R.id.zxing:
//                intent = new Intent(getContext() , Zxing);
//                startThActivityByIntent();
            case  R.id.calculator:
                intent = new Intent(getContext() , Calculator.class);
                startThActivityByIntent(intent);
                break;
            case  R.id.game:
                intent = new Intent(getContext() , GameActivity.class);
                startThActivityByIntent(intent);
                break;
        }
    }

}
