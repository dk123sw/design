package dk.dkln.utils;

/**
 * Created by dk on 2016/11/14.
 */
public class BookApiUtils {
    public static String Book_Titles []={"推荐","爱情","友情","名著"};


    public static String getApiTag(int pos){
        switch (pos){
            case 0:
                return Book_Titles[0];
            case 1:
                return Book_Titles[1];
            case 2:
                return Book_Titles[2];
            case 3:
                return Book_Titles[3];

        }
        return null;
    }


//    public static  String getRandomTAG(List<String> list){
//        Random random=new Random();
//        int i=random.nextInt(list.size());
//        return  list.get(i);
//    }
}
