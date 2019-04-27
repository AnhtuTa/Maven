package jsoup_demo;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class QueryLinks {
	public static void main(String[] args) throws IOException {
		Connection conn = Jsoup.connect("https://o7planning.org").userAgent(GetDocumentExamples.FAKE_MOZILLA_AGENT);

		Document doc = conn.get();

		// Truy vấn các phần tử a mà href chứa /document/
		String cssQuery = "a[href*=/document/]";
		Elements elements = doc.select(cssQuery);
		Iterator<Element> iterator = elements.iterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			System.out.println(e.attr("href"));
		}

		// Truy vấn các phần tử a mà href chứa /1016/
		cssQuery = "a[href*=/1016]";
		elements = doc.select(cssQuery);
		iterator = elements.iterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			System.out.println(e.attr("href"));
		}

		System.out.println("Done!");
	}
}
