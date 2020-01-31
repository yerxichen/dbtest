package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PconlineSpider {

    Logger logger= LoggerFactory.getLogger(PconlineSpider.class);

    public void parseHtml(String html){
        Document doc= Jsoup.parse(html);
        Element list=doc.getElementById("JlistItems");
        Elements items=list.getElementsByClass("item");
        for(Element item:items){
            try {
                String picture=item.getElementsByClass("item-pic").first().getElementsByTag("a").first().getElementsByTag("img").first().attr("#src");
                String xx_url=item.getElementsByClass("item-pic").first().getElementsByTag("a").first().attr("href");
                String name=item.getElementsByClass("item-title-name").first().text();
                String price=item.getElementsByClass("price price-now").first().text();
                String sn_price=item.getElementsByClass("xs1 buyLink").first().text();
                String jd_price=item.getElementsByClass("xs2 buyLink").first().text();
                logger.info("picture===>"+picture);
                logger.info("xx_url===>"+xx_url);
                logger.info("name===>"+name);
                logger.info("price===>"+price);
                logger.info("sn_price===>"+sn_price);
                logger.info("jd_price===>"+jd_price);
            }catch (Exception e){
                System.err.println("报错了，这个item可能是下一页按钮！");
            }
        }
    }

    public void parseXx(){

    }
}
