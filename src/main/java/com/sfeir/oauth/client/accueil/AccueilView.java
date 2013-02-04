package com.sfeir.oauth.client.accueil;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created with IntelliJ IDEA.
 * User: sfeir
 * Date: 24/01/13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
public interface AccueilView extends IsWidget {

    void setPresenter(Presenter listener);
    void informMessage(String s);

    public interface Presenter {
        void goTo(Place place);

        void doGoogleAuthent();

        void doClearTokens();

        void goSecuredPages();
    }
}
