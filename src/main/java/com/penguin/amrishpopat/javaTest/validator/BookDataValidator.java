package com.penguin.amrishpopat.javaTest.validator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.penguin.amrishpopat.javaTest.model.Book;


@Component
public class BookDataValidator {

	public static Optional<Book> validate(Optional<Book> book) {
		if (hasNullItems(book.get())) {
			return Optional.empty();
		} else {
			return Optional.of(makeSecure(book.get()));
		}
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
			//System.out.println("Current Value: "+ html);
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
