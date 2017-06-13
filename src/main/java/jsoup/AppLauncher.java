package jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Product;

public class AppLauncher {

	public static String url = "http://shop.lululemon.com/c/men/run/_/N-7tuZ1z141cp?mnid=mn;en-US;men;activity;run";
	
	public static void main(String[] args) throws IOException {
			 
			 Document doc = Jsoup.connect(url).get();
			 Elements listing = doc.getElementsByClass("tile-visible");
			 
			 List<Product> product_list = new ArrayList<Product>();
			 
			 
			 for (Element ele : listing) {
			
				 Elements name = ele.getElementsByClass("tile-text");
				 Product p = new Product();
				 p.name = name.size() > 0 ? name.get(0).text() : null;
				 
				 Elements meta_info = ele.getElementsByClass("tile-meta");
				 p.price = meta_info.size() > 0 ? meta_info.get(0).text() : "";
				 
				 System.out.println(p.toString());
				 
				 product_list.add(p);
				
			}
			 
			 System.out.println("Total Listing Scraped " + product_list.size());

	}

}
