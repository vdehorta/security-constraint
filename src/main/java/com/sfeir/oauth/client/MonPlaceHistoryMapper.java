package com.sfeir.oauth.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.sfeir.oauth.client.accueil.AccueilPlace;
import com.sfeir.oauth.client.basicpage.AuthenticationPocPlace;

@WithTokenizers({
        AccueilPlace.Tokenizer.class,
        AuthenticationPocPlace.Tokenizer.class
})
public interface MonPlaceHistoryMapper extends PlaceHistoryMapper {

}
