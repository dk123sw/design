package dk.dkln.bean.movie;

import java.io.Serializable;

/**
 * Created by dk on 2016/10/29.
 */

public class Directors implements Serializable{
    private String alt;
    private ImageBean avatars;

    public ImageBean getAvatars() {
        return avatars;
    }

    public void setAvatars(ImageBean avatars) {
        this.avatars = avatars;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
