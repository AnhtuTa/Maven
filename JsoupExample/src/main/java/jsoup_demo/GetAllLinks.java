package jsoup_demo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetAllLinks {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://eclipse.org").get();
		Elements aElements = doc.getElementsByTag("a");
		for (Element a : aElements) {
			String href = a.attr("href");
			String text = a.text();
			System.out.println("<a href=\"" + href + "\">" + text + "</a>");
		}
		System.out.println("\n==========================\n");

		// Lỗi nếu truy cập vào o7planning.org
		// doc = Jsoup.connect("https://o7planning.org").get();

		// Phải làm như sau
		doc = Jsoup.connect("https://o7planning.org").userAgent(GetDocumentExamples.FAKE_MOZILLA_AGENT).get();
		aElements = doc.getElementsByTag("a");
		for (Element a : aElements) {
			String href = a.attr("href");
			String text = a.text();
			System.out.println("<a href=\"" + href + "\">" + text + "</a>");

		}
		System.out.println("\n==========================\n");
	}
}
