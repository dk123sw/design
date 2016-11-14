package dk.dkln.mvp.model.book;

import dk.dkln.mvp.ApiCompleteListener;

/**
 * Created by dk on 2016/11/14.
 */
public interface IBookListModel {

    /**
     * 获取图书接口
     */
    void loadBookList(String q, String tag, int start, int count,  ApiCompleteListener listener);

    /**
     * 取消加载数据
     */
    void cancelLoading();
}
