package dk.dkln.bean.movie;

import java.io.Serializable;

/**
 * Created by dk on 2016/10/29.
 */

public class CastsBean implements Serializable{

    /**
     * alt : https://movie.douban.com/celebrity/1054521/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg"}
     * name : 蒂姆·罗宾斯
     * id : 1054521
     */

    private String alt;
    /**
     * small : https://img3.doubanio.com/img/celebrity/small/17525.jpg
     * large : https://img3.doubanio.com/img/celebrity/large/17525.jpg
     * medium : https://img3.doubanio.com/img/celebrity/medium/17525.jpg
     */

    private AvatarsBean avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public AvatarsBean getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBean avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
