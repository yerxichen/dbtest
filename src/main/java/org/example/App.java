package org.example;

import org.utils.HttpClientUtil;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String html=HttpClientUtil.doGet("https://product.pconline.com.cn/cpu/");
        PconlineSpider spider=new PconlineSpider();
        spider.parseHtml(html);
    }
}
