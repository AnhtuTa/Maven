package examples;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlTrivagoDemo {
	public static final String FAKE_MOZILLA_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";

	public static void main(String[] args) throws IOException {
		String url = "https://www.trivago.vn/?aDateRange%5Barr%5D=2018-04-28&aDateRange%5Bdep%5D=2018-04-29&aPriceRange%5Bto%5D=0&aPriceRange%5Bfrom%5D=0&iPathId=87889&aGeoCode%5Blat%5D=21.031937&aGeoCode%5Blng%5D=105.83918&iGeoDistanceItem=0&aCategoryRange=0%2C1%2C2%2C3%2C4%2C5&aOverallLiking=1%2C2%2C3%2C4%2C5&sOrderBy=relevance%20desc&bTopDealsOnly=false&iRoomType=7&cpt=8788903%2C134000&iIncludeAll=0&aHotelTestClassifier=&aPartner=&iViewType=0&bIsSeoPage=false&bIsSitemap=false&";
		Document doc = Jsoup.connect(url).userAgent(FAKE_MOZILLA_AGENT).get();
		System.out.println(doc);
		
		Elements hotelElements = doc.select("div.item__wrapper");
		for(Element hotel : hotelElements) {
			System.out.println(hotel);
			//Tại sao thêm dòng sau lại ko in ra được gì?
			//System.out.println("\n=============\n");
			//hotel.get
		}
		
		System.out.println("Done!");
	}
}
