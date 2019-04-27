package jsoup_demo;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CssJqueryDemo {
	public static void main(String[] args) throws IOException {
		// Các phương thức tương tự Css, jQuery
		Connection conn = Jsoup.connect("https://o7planning.org")
				.userAgent(GetDocumentExamples.FAKE_MOZILLA_AGENT)
				.timeout(10*1000);
		Document doc = conn.get();

		// Phần tử a với thuộc tính href
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			System.out.println(link);
		}
		System.out.println("\n==========================\n");

		// img với thuộc tính src kết thúc bởi .png
		Elements pngs = doc.select("img[src$=.png]");
		for (Element png : pngs) {
			System.out.println(png);
		}
		System.out.println("\n==========================\n");

		// div với class=masthead
		Element masthead = doc.select("div.masthead").first();
		System.out.println(masthead);

		System.out.println("\n==========================\n");

		// Phần tử a ngay sau h3.
		Elements resultLinks = doc.select("h3.r > a");
		for (Element resultLink : resultLinks) {
			System.out.println(resultLink);
		}
		System.out.println("\n==========================\n");
	}
}
