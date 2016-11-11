package dk.dkln.bean.movie;


import java.util.List;

public class MoiveSeriesListRespnse extends MovieInfoResponse {


    /**
     * rating : {"max":10,"average":4.9,"stars":"25","min":0}
     * reviews_count : 24
     * wish_count : 686
     * douban_site :
     * year : 2016
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2394844095.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2394844095.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2394844095.jpg"}
     * alt : https://movie.douban.com/subject/26415200/
     * id : 26415200
     * mobile_url : https://movie.douban.com/subject/26415200/mobile
     * title : 外公芳龄38
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/26415200
     * seasons_count : null
     * schedule_url : https://movie.douban.com/subject/26415200/cinema/
     * episodes_count : null
     * countries : ["中国大陆","韩国"]
     * genres : ["剧情","喜剧"]
     * collect_count : 344
     * casts : [{"alt":"https://movie.douban.com/celebrity/1009179/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1368762337.01.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1368762337.01.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1368762337.01.jpg"},"name":"佟大为","id":"1009179"},{"alt":"https://movie.douban.com/celebrity/1313303/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/37554.jpg","large":"https://img3.doubanio.com/img/celebrity/large/37554.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/37554.jpg"},"name":"陈妍希","id":"1313303"},{"alt":"https://movie.douban.com/celebrity/1355329/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1478848828.8.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1478848828.8.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1478848828.8.jpg"},"name":"吕云骢","id":"1355329"},{"alt":"https://movie.douban.com/celebrity/1339588/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1459505630.4.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1459505630.4.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1459505630.4.jpg"},"name":"刘芮麟","id":"1339588"}]
     * current_season : null
     * original_title : 外公芳龄38
     * summary : 38岁的明星主播何志武（佟大为 饰）在家中精心打扮，准备迎接性感女友“临幸”。打开家门时，外面站着的却是一对陌生母子——来自“胡建”的20岁未婚妈妈唐慧茹（陈妍希 饰）带着5岁的儿子唐家栋（吕云骢 饰）上门认亲……面对从天而降的女儿和小萌孙，正值”芳龄“的何志武无法接受， 要求进行亲子鉴定！然而，结局却令人出乎意料……©豆瓣
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1276884/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/46669.jpg","large":"https://img1.doubanio.com/img/celebrity/large/46669.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/46669.jpg"},"name":"安兵基","id":"1276884"}]
     * comments_count : 209
     * ratings_count : 308
     * aka : ["极速绯闻","超速绯闻","非常主播","非常主播中国版","Scandal Maker"]
     */

    private String year;
    /**
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2394844095.jpg
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2394844095.jpg
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2394844095.jpg
     */

    private ImagesBean images;
    private String id;
    private String mobile_url;
    private String title;
    private String summary;
    private List<String> genres;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public static class ImagesBean {
        private String large;

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }
    }
}
