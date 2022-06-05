package com.dummy.networkapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
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
