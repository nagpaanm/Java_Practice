package htmlEntityParser;

import java.util.HashMap;

/*
 * HTML entity parser is the parser that takes HTML code as input and replace all 
 * the entities of the special characters by the characters itself.

The special characters and their entities for HTML are:

Quotation Mark: the entity is &quot; and symbol character is ".
Single Quote Mark: the entity is &apos; and symbol character is '.
Ampersand: the entity is &amp; and symbol character is &.
Greater Than Sign: the entity is &gt; and symbol character is >.
Less Than Sign: the entity is &lt; and symbol character is <.
Slash: the entity is &frasl; and symbol character is /.
Given the input text string to the HTML parser, you have to implement the entity parser.

Return the text after replacing the entities by the special characters.
 */
public class Solution {

	 public String entityParser(String text) {
		 
		 HashMap<String, String> map_ = new HashMap<String, String>();
		 map_.put("&quot;", "\"");
		 map_.put("&apos;", "'");
		 map_.put("&gt;", ">");
		 map_.put("&lt;", "<");
		 map_.put("&frasl;", "/");
		 for(String key: map_.keySet()) {
			 text = text.replaceAll(key, map_.get(key));
		 }
		 
		 return text.replaceAll("&amp;", "&");
		 
		 // O(n) solution
		 /* 
		 String newText = "";
		 
		 // O(n)
		 for(int i = 0 ; i < text.length(); i++) {
			 int j = i;
			 if(String.valueOf(text.charAt(i)).equals("&")) {
				 if(i + 3 < text.length()) {
					 // O(1)
					 if(text.substring(i + 1, i + 4).equals("gt;")) {
						 newText += ">";
						 i += 3;
						 continue;
					 }
					// O(1)
					 else if(text.substring(i + 1, i + 4).equals("lt;")) {
						 newText += "<";
						 i += 3;
						 continue;
					 }
				 }
				 if(i + 4 < text.length()) {
					// O(1)
					 if(text.substring(i + 1, i + 5).equals("amp;")) {
						 newText += "&";
						 i += 4;
						 continue;
					 }
				 }
				 if(i + 5 < text.length()) {
					// O(1)
					 if(text.substring(i + 1, i + 6).equals("quot;")) {
						 newText += "\"";
						 i += 5;
						 continue;
					 }
					// O(1)
					 else if(text.substring(i + 1, i + 6).equals("apos;")) {
						 newText += "'";
						 i += 5;
						 continue;
					 }
				 }
				 if(i + 6 < text.length()) {
					// O(1)
					 if(text.substring(i + 1, i + 7).equals("frasl;")) {
						 newText += "/";
						 i += 6;
						 continue;
					 }
				 }
				 if(j == i) {
					 // & was found but no html match
					 newText += String.valueOf(text.charAt(i));
					 continue;
				 }
			 }
			 else {
				 newText += String.valueOf(text.charAt(i));
			 }
		 }
	    return newText;
	    */
	 }
}
