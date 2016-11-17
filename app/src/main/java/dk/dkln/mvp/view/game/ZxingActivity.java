package dk.dkln.mvp.view.game;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dk.dkln.base.BaseActivity;
import dk.dkln.R;

public class ZxingActivity extends BaseActivity {


    @BindView(R.id.scan_result)
    TextView scan_result;
    @BindView(R.id.produce_result)
    EditText produce_result;
    @BindView(R.id.pictures)
    ImageView picture;

    private String shuru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_zxing;
    }

    @Override
    public boolean canBack() {
        return true;
    }

    @OnClick(R.id.scan)
    public void scan(View view){
        Intent intent = new Intent(this , CaptureActivity.class);
        startActivityForResult(intent , 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            String result = data.getExtras().getString("result");
            scan_result.setText(result);
        }
    }

    @OnClick(R.id.produce)
    public void produce(View view) {
        shuru = produce_result.getText().toString();
        if (!shuru.equals(""))
        {
            Bitmap bitmap = EncodingUtils.createQRCode(shuru ,1000, 1000,null);
            picture.setImageBitmap(bitmap);
        }
    }
}
