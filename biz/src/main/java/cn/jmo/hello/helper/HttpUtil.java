package cn.jmo.hello.helper;

import com.github.kevinsawicki.http.HttpRequest;

/**
 * Created by qiangzi on 16/6/11.
 */
public class HttpUtil {


    public static void get(String url){
        HttpRequest request = HttpRequest.get("http://www.baidu.com");
        System.out.println(request.code());
        System.out.println(request.body());

    }


    public static void main(String[] args) {
        get("");
    }
}
