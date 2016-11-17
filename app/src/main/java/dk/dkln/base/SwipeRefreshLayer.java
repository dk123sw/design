package dk.dkln.base;

/**
 * Created by dk on 2016/11/7.
 */

public interface SwipeRefreshLayer {
    void requestDataRefresh();

    void setRefresh(boolean refresh);

    void setProgressViewOffset(boolean scale, int start, int end);

    void setCanChildScrollUpCallback(MultiSwipeRefreshLayout.CanChildScrollUpCallback callback);
}
