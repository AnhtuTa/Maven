package jsoup_demo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SelectorDemo1 {
	public static void main(String[] args) throws IOException {
		File htmlFile = new File("demo.html");
		Document doc = Jsoup.parse(htmlFile, "UTF-8");

		// Phần tử <div> đầu tiên có class ="related-container".
		Element div = doc.select("div.related-container").first();

		// Danh sách các phần tử <h3>, con trực tiếp của phần tử hiện tại.
		Elements h3Elements = div.select("> h3");

		// Lấy phần tử h3 đầu tiên
		Element h3 = h3Elements.first();

		System.out.println(h3.text());

		// Danh sách các phần tử <a> hậu duệ của phần tử hiện tại.
		Elements aElements = div.select("a");

		// Truy vấn trong danh sách phần tử hiện tại.
		// Các phần tử mà href có chứa từ installing.

		Elements aEclipses = aElements.select("[href*=Installing]");

		Iterator<Element> iterator = aEclipses.iterator();

		while (iterator.hasNext()) {
			Element a = iterator.next();
			System.out.println("Document: " + a.text());
		}
	}

}
