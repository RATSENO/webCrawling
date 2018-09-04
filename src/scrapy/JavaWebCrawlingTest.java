package scrapy;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JavaWebCrawlingTest {
	
	public static String getCurrentDate() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd HH::mm:ss");
		return simpleDate.format(new Date());
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("시작일:" + getCurrentDate());
	
		Scanner stdIn = new Scanner(System.in);
		System.out.print("url 입력:");
		String url = stdIn.next();
		
		
		String og_title = "";
		String og_image = "";
		String og_desc  = "";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements metaOgTitle =  doc.select("meta[property=og:title]");
		if(metaOgTitle != null) {
			og_title = metaOgTitle.attr("content");
		}
		
		Elements metaOgImage =  doc.select("meta[property=og:image]");
		if(metaOgTitle != null) {
			og_image = metaOgImage.attr("content");
		}
		
		Elements metaOgDesc =  doc.select("meta[property=og:description]");
		if(metaOgTitle != null) {
			og_desc = metaOgDesc.attr("content");
		}
		
		System.out.println(url+"의 meta 태그 값");
		System.out.println("og:title 은 "+og_title);
		System.out.println("og:image 은 "+og_image);
		System.out.println("og:description 은 "+og_desc);
	
	}
	

}
