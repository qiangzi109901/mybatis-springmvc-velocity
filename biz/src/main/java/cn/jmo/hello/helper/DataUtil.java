package cn.jmo.hello.helper;

/**
 * Created by qiangzi on 16/6/10.
 */
public class DataUtil {

    public static int toInt(String s){
        return toInt(s, 0);
    }

    public static int toInt(String s, int def){
        try {
            return Integer.parseInt(s);
        }
        catch (Exception e){
            return def;
        }
    }

}
