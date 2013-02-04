package com.sfeir.oauth.client.accueil;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AccueilPlace extends Place {
    @Prefix("authenticationBack/accueil")
	public static class Tokenizer  implements PlaceTokenizer<AccueilPlace>{

		public AccueilPlace getPlace(String arg0) {
			return new AccueilPlace();
		}

		public String getToken(AccueilPlace arg0) {
			return "";
		}
	}
}
