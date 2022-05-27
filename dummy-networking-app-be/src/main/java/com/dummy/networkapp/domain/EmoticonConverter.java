package com.dummy.networkapp.domain;

import java.util.HashMap;
import java.util.Map;

//TODO: @Veronika: I have no idea where to place this converter so I left it alone for now. 
// A test is there too, but at the moment I lacking ideas how to test it really hard
public class EmoticonConverter {

		private Map<String, String> emoticons = new HashMap<String, String>();
		
		public EmoticonConverter() {
			emoticons.put(":-)", "🙂");
			emoticons.put(":-D", "😄");
			emoticons.put(":-(", "🙁");
			emoticons.put(":-P", "😛");
			emoticons.put(":)", "🙂");
			emoticons.put(":D", "😄");
			emoticons.put(":(", "🙁");
			emoticons.put(":P", "😛");
			
		}
		
		public String convert(String text) {
			for(String key : emoticons.keySet()) {
				text = text.replace(key, emoticons.get(key));
			}
			
			return text;
		}
}
