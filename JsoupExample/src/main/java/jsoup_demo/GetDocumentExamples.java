package jsoup_demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetDocumentExamples {
	public static final String FAKE_MOZILLA_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";

	public static void main(String[] args) throws IOException {
		// Tạo Documet từ URL
		Document doc = Jsoup.connect("http://eclipse.org").get();
		String title = doc.title();
		System.out.println("Title : " + title);
		System.out.println("\n==========================\n");

		// Tạo Documet từ URL object 
		doc = Jsoup.parse(new URL("http://eclipse.org"), 10000);
		title = doc.title();
		System.out.println("Title : " + title);
		System.out.println("\n==========================\n");
		
		// Tạo Document từ File
		doc = Jsoup.parse(new File(System.getProperty("user.dir") + "/trangchu.html"), "UTF-8");
		title = doc.title();
		System.out.println("Title : " + title);
		System.out.println("\n==========================\n");

		// Tạo Document từ String
		String htmlString = "<html><head><title>Simple Page</title></head>" + "<body>Hello</body></html>";
		doc = Jsoup.parse(htmlString);
		title = doc.title();
		System.out.println("Title : " + title);
		System.out.println("Content:\n");
		System.out.println(doc.toString());
		System.out.println("\n==========================\n");

		// Phân tích đoạn HTML
		String htmlFragment = "<h1>Hi you!</h1><p>What is this?</p>";
		doc = Jsoup.parseBodyFragment(htmlFragment);
		String fullHtml = doc.html();
		System.out.println(fullHtml);
		System.out.println("\n==========================\n");
		

	}
}
