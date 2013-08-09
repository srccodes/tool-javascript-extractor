package com.srccodes.tools.html.extractor;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 */
public class JavaScriptExtractor {
	public static void main(String[] args) throws IOException {
		OutputSettings outputSettings = new OutputSettings();
		outputSettings.prettyPrint(true);
		
		Document doc = Jsoup.connect("http://wikimapia.org")
				.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/536.30.1 (KHTML, like Gecko) Version/6.0.5 Safari/536.30.1")
				.followRedirects(true)
				.get().outputSettings(outputSettings);

		Elements scriptElems = doc.select("script");

		for (Element scriptElem : scriptElems) {
			System.out.println(scriptElem.outerHtml());
			System.out.println("****************************");
		}
	}
}
