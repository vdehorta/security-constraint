package com.sfeir.oauth.client.basicpage;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AuthenticationPocPlace extends Place {
    @Prefix("authenticationBack/poc")
	public static class Tokenizer  implements PlaceTokenizer<AuthenticationPocPlace>{

		public AuthenticationPocPlace getPlace(String arg0) {
			return new AuthenticationPocPlace();
		}

		public String getToken(AuthenticationPocPlace arg0) {
			return "";
		}
	}
}
