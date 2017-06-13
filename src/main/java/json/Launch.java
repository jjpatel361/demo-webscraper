package json;

import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

/**
 * @author Jay Patel
 *
 */
public class Launch {
	
	public static final String URL = "http://propertiesplus.newjersey.remax.com/api/listings/?location=Harrison,%20NJ&nwlat=40.75532843346839&nwlong=74.16897336517334&selat=40.74198233163965&selong=74.14399663482666&Count=25&pagenumber=1&SiteID=60320268&pageCount=10&sh=true&maplistings=1&maplistcards=5&sv=true&sortorder=newest&&_=1496892940779";

	public static void main(String[] args) throws IOException {
		
		String json = Jsoup.connect(URL).ignoreContentType(true).execute().body();
		
		JSONArray container = new JSONArray(json);
		
		JSONArray listing = container.getJSONArray(0);
		
		JSONObject product_info = listing.getJSONObject(0);
		
		Iterator<?> keys = product_info.keys();
		
		while (keys.hasNext()){
			String key = (String) keys.next();
			System.out.println( key +" "+  product_info.get(key));
		}
		
		
		
		
		

	}

}
