package dk.dkln.mvp;


import dk.dkln.bean.BaseResponse;

/**
 * 网络请求回调接口
 */
public interface ApiCompleteListener {
    void onComplected(Object result);

    void onFailed(BaseResponse msg);
}