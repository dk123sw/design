package dk.dkln.mvp.view.game;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dk.dkln.R;


public class Calculator extends AppCompatActivity {


    @BindView(R.id.input)
    @Nullable TextView input;
    @BindView(R.id.result)
    @Nullable TextView result;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
//        view = getWindow().findViewById(R.id.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.nine , R.id.eight ,R.id.seven , R.id.six ,R.id.five ,R.id.four ,R.id.three,
            R.id.two ,R.id.one , R.id.zero ,R.id.jia ,R.id.jian ,R.id.cheng ,R.id.chu ,R.id.dian})
    public void Number(View view){
        Button btn = (Button)view;
        String strAdd = btn.getText().toString();
        String strContent = input.getText().toString();
        String strAllContent = strContent+strAdd;
        input.setText(strAllContent);
    }
    /**
     * 在设置setText之后无法第一时间更新界面
     */

    @OnClick({R.id.c , R.id.del , R.id.deng})
    public void Cal(View view){
        switch (view.getId()){
            case R.id.c:
                input.setText("");
                result.setText("");
//                去掉下面这句就好了??什么鬼
//                view.invalidate();
                break;
            case R.id.del:
                String content = input.getText().toString();
                if(content.length() > 0) {
                    content = content.substring(0, content.length() - 1);
                    input.setText(content);
                    if (content.length() == 0.5f){
                        input.setText("");
                    }
                }
                break;
            case R.id.deng:
                String scontent = input.getText().toString();
                try{
                    Symbols s = new Symbols();
                    double res = s.eval(scontent);
                    result.setText(String.valueOf(res));
                    Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
                    result.startAnimation(fadeIn);

                    Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
                    input.startAnimation(fadeOut);
                    fadeOut.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {

                            input.setText("");
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });


                }catch (SyntaxException e){
                    String zcontent = input.getText().toString();
                    if (zcontent.length() == 0){
                        Toast.makeText(this , "请输入数字" , Toast.LENGTH_SHORT).show();
                    }else {
                        String str = "错误";
                        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String needContent = input.getText().toString();
        outState.putString("Key_Input" , needContent);

        String resContent = result.getText().toString();
        outState.putString("Key_Result" , resContent);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String needContent = savedInstanceState.getString("Key_Input");
        input.setText(needContent);

        String resContent = savedInstanceState.getString("Key_Result");
        result.setText(resContent);
    }

}
