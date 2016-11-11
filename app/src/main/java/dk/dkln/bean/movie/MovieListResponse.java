package dk.dkln.bean.movie;

import java.io.Serializable;

import me.drakeet.multitype.Item;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieListResponse implements Serializable,Item {

    public static final long serialVersionUID = 7060254125600464481L;
    public static final String serialVersionName = "movieList";

    private String id;
    private String title;
    private String original_title;
    private String alt;
    private ImageBean images;
    private MovieRatingBean rating;
    private String year;
    private String subtype;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getSerialVersionName() {
        return serialVersionName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageBean getImages() {
        return images;
    }

    public void setImages(ImageBean images) {
        this.images = images;
    }

    public MovieRatingBean getRating() {
        return rating;
    }

    public void setRating(MovieRatingBean rating) {
        this.rating = rating;
    }
}
