package dk.dkln.bean.book;

import java.io.Serializable;
import java.util.List;

import me.drakeet.multitype.Item;

/**
 * Created by dk on 2016/11/14.
 */
public class BookListResponse implements Serializable ,Item {


    /**
     * 属性适配
     */
    public BookListResponse(String summary) {
        this.summary = summary;
    }

    //简介
    public static class BookListResponseBrief extends BookListResponse {
        public BookListResponseBrief(String summary) {
            super(summary);
        }
    }

    public static final long serialVersionUID = 7060254125600464481L;
    public static final String serialVersionName = "bookInfo";

    /**
     * max : 10
     * numRaters : 100397
     * average : 8.5
     * min : 0
     */

    private RatingBean rating;
    /**
     * rating : {"max":10,"numRaters":100397,"average":"8.5","min":0}
     * subtitle :
     * author : ["[英] 夏洛蒂·勃朗特"]
     * pubdate : 2003-11
     * tags : [{"count":17282,"name":"简爱","title":"简爱"},{"count":16668,"name":"外国文学","title":"外国文学"},{"count":10686,"name":"经典","title":"经典"},{"count":9726,"name":"爱情","title":"爱情"},{"count":9442,"name":"小说","title":"小说"},{"count":7990,"name":"名著","title":"名著"},{"count":7119,"name":"英国","title":"英国"},{"count":5723,"name":"外国名著","title":"外国名著"}]
     * origin_title : Jane Eyre
     * image : https://img5.doubanio.com/mpic/s5924326.jpg
     * binding : 平装
     * translator : []
     * catalog :

     * pages : 436
     * images : {"small":"https://img5.doubanio.com/spic/s5924326.jpg","large":"https://img5.doubanio.com/lpic/s5924326.jpg","medium":"https://img5.doubanio.com/mpic/s5924326.jpg"}
     * alt : https://book.douban.com/subject/1141406/
     * id : 1141406
     * publisher : 世界图书出版公司
     * isbn10 : 750626157X
     * isbn13 : 9787506261579
     * title : 简爱
     * url : https://api.douban.com/v2/book/1141406
     * alt_title : Jane Eyre
     * author_intro :
     * summary : 《简爱》是英国女作家夏洛蒂·勃朗特的代表作品。女主人公简爱是一个追赶求平等与自主的知识女性形象，小说以其感人的对于一位“灰姑娘式”人物奋斗史的刻划取胜，《简爱》也是女性文学的代表作品。
     * series : {"id":"61","title":"名著典藏"}
     * price : 18.00元
     */

    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    /**
     * small : https://img5.doubanio.com/spic/s5924326.jpg
     * large : https://img5.doubanio.com/lpic/s5924326.jpg
     * medium : https://img5.doubanio.com/mpic/s5924326.jpg
     */

    private ImagesBean images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    /**
     * id : 61
     * title : 名著典藏
     */

    private SeriesBean series;
    private String price;
    private String[] author;
    /**
     * count : 17282
     * name : 简爱
     * title : 简爱
     */

    private List<TagsBean> tags;
    private String[] translator;

    public String getInfoString() {
        if (this.author.length > 0) {
            return this.author[0].split("、")[0] + "/" + this.publisher + "/" + this.pubdate;
        }
        return "-";
    }

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getSerialVersionName() {
        return serialVersionName;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public SeriesBean getSeries() {
        return series;
    }

    public void setSeries(SeriesBean series) {
        this.series = series;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public String[] getTranslator() {
        return translator;
    }

    public void setTranslator(String[] translator) {
        this.translator = translator;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public static class RatingBean {
        private int max;
        private int numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class SeriesBean {
        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class TagsBean {
        private int count;
        private String name;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
