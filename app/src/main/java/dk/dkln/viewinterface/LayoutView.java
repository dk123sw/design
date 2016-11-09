package dk.dkln.viewinterface;

/**
 * Created by dk on 2016/11/9
 * 所有外层fragment继承刷新布局
 */

public interface LayoutView extends BaseView {

    void showMessage(String msg);

    void showProgress();

    void hideProgress();
}
