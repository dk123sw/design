package dk.dkln.bean.movie;

import me.drakeet.multitype.Item;

/**
 * Created by dk on 2016/10/29.
 */

public class MovieListResponse implements Item {

    public static final long serialVersionUID = 7060254125600464481L;
    public static final String serialVersionName = "movieList";

/**    "rating":Object{...},
            "genres":Array[3],
            "title":"奇异博士",
            "casts":Array[3],
            "collect_count":98095,
            "original_title":"Doctor Strange",
            "subtype":"movie",
            "directors":Array[1],
            "year":"2016",
            "images":Object{...},
            "alt":"https://movie.douban.com/subject/3025375/",
            "id":"3025375"
 */

    private String id;
    private String title;
    private String original_title;
    private String alt;
    private ImageBean images;
    private MovieRatingBean rating;
    private String year;
    private String subtype;
    private String collect_count;
//    private CastsBean[] casts;
//    private Directors[] directors;
    private String[] genres;

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(String collect_count) {
        this.collect_count = collect_count;
    }

//    public CastsBean[] getCasts() {
//        return casts;
//    }
//
//    public void setCasts(CastsBean[] casts) {
//        this.casts = casts;
//    }
//
//    public Directors[] getDirectors() {
//        return directors;
//    }
//
//    public void setDirectors(Directors[] directors) {
//        this.directors = directors;
//    }

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
