package jsoup_demo;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReadHtmlForm {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.parse(new File(System.getProperty("user.dir") + "/trangchu.html"), "utf-8");
		
		Element form = doc.getElementById("form_search");
		System.out.println("Form action = " + form.attr("action"));

		Elements inputElements = form.getElementsByTag("input");
		for (Element inputElement : inputElements) {
			String key = inputElement.attr("name");
			String value = inputElement.attr("value");

			System.out.println(key + " =  " + value);
		}
		
		Elements selectElements = form.getElementsByTag("select");
		for(Element e : selectElements) {
			String key = e.attr("name");
			String value = e.attr("value");

			System.out.println(key + " =  " + value);
		}
	}
}
