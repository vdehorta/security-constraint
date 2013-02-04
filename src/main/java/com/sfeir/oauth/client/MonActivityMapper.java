package com.sfeir.oauth.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.sfeir.oauth.client.accueil.AccueilActivity;
import com.sfeir.oauth.client.accueil.AccueilPlace;
import com.sfeir.oauth.client.basicpage.AuthenticationPocActivity;
import com.sfeir.oauth.client.basicpage.AuthenticationPocPlace;

public class MonActivityMapper implements ActivityMapper {

	private final Map<Class<? extends Place>, Activity> map = new HashMap<Class<? extends Place>, Activity>();

	public MonActivityMapper() {
        map.put(AccueilPlace.class, new AccueilActivity());
        map.put(AuthenticationPocPlace.class, new AuthenticationPocActivity());

    }

	public Activity getActivity(Place place) {

		Activity activity =  map.get(place.getClass());
		return activity;
	}

}
