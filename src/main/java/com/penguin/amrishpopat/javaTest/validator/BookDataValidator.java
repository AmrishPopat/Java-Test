package com.penguin.amrishpopat.javaTest.validator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.penguin.amrishpopat.javaTest.model.Book;


@Component
public class BookDataValidator {

	public static Optional<Book> validate(Book book) {
		if (hasNullItems(book) || brokenLink(book)) {
			return Optional.empty();
		} else {
			return Optional.of(makeSecure(book));
		}
	}
	
	private static boolean brokenLink(Book bookItem) {
        try {
        	HttpURLConnection huc = null;
        	int respCode = 200;
        	
            huc = (HttpURLConnection)(new URL(bookItem.getUrl()).openConnection());
            
            huc.setRequestMethod("HEAD");
            
            huc.connect();
            
            respCode = huc.getResponseCode();
            
            if(respCode < 300 && respCode >=200 ){
                return false;
            }
                
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }		
		return true;
	}

	private static Book makeSecure(Book bookItem) {
		
		  bookItem.setAuthor(removeScriptContent(bookItem.getAuthor()));
		  bookItem.setImage(removeScriptContent(bookItem.getImage()));
		  bookItem.setTitle(removeScriptContent(bookItem.getTitle()));
		  bookItem.setUrl(removeScriptContent(bookItem.getUrl()));
		 
		return bookItem;
	}

	private static String removeScriptContent(String html) {
		if (html != null) {
			String re = "(<script>.*?</script>)";

			Pattern pattern = Pattern.compile(re);
			Matcher matcher = pattern.matcher(html);
			if (matcher.find()) {
				 return html.replace(matcher.group(1), "");
			}
			return html;
		}
		return null;
	}

	private static boolean hasNullItems(Book bookItem) {
		if (isNullOrEmpty(bookItem.getUrl()) || isNullOrEmpty(bookItem.getImage()) || isNullOrEmpty(bookItem.getAuthor()) || isNullOrEmpty(bookItem.getTitle())) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

}
