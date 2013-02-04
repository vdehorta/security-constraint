package com.sfeir.oauth.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.sfeir.oauth.client.accueil.AccueilPlace;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OAuth implements EntryPoint {

    private static EventBus eventBus = new SimpleEventBus();
    private static PlaceController placeController = new PlaceController(
            eventBus);

    private SimplePanel displayAffichage;

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */


    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        PlaceHistoryMapper placeHistoryMapper = GWT
                .create(MonPlaceHistoryMapper.class);
        PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(
                placeHistoryMapper);

    Place defaultPlace = new AccueilPlace();
        placeHistoryHandler.register(placeController, eventBus, defaultPlace);
        // </la sauce pour aller de l'URL a la place>

        // <la sauce pour aller de la place vers l'activite qui s'affiche>
        ActivityMapper mapper = new MonActivityMapper();

        // Controleur d'une region d'affichage
        ActivityManager activityManager = new ActivityManager(mapper, eventBus);
        displayAffichage = new SimplePanel();
        activityManager.setDisplay(displayAffichage);

        // </la sauce pour aller de la place vers l'activite qui s'affiche>

        // Demarre l'activite qui correspond a l'historique courant
        placeHistoryHandler.handleCurrentHistory();

        RootPanel.get("body").add(displayAffichage);
    }

    public static PlaceController getPlaceController() {
        return placeController;
    }
}
