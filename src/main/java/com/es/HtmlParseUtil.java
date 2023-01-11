package com.es;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {
    public static void main(String[] args) throws Exception {

        System.out.println(parseJd("vue"));
    }
    public static List<Content> parseJd(String keyword){
        List<Content> contentList =  new ArrayList<>();
        String url = "https://search.jd.com/Search?keyword="+keyword;
        //
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url),30000);
        } catch (IOException e) {
            e.printStackTrace();
            return contentList;
        }
        Element element = document.getElementById("J_goodsList");
        // System.out.println(element.html());
        Elements elements = element.getElementsByTag("li");
        String img;
        String price;
        String title;

        for (Element el : elements) {
             img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
             price = el.getElementsByClass("p-price").eq(0).text();
             title = el.getElementsByClass("p-name").eq(0).text();
            //System.out.printf("img:%s price:%s title:%s\r\n",img,price,title);
            contentList.add(new Content(title,price,img));
        }
        return contentList;
    }
}
