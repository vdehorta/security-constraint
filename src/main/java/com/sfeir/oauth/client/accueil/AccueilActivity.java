package com.sfeir.oauth.client.accueil;
import com.google.api.gwt.oauth2.client.Auth;
import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.Callback;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sfeir.oauth.client.OAuth;
import com.sfeir.oauth.client.basicpage.AuthenticationPocPlace;

public class AccueilActivity extends AbstractActivity implements AccueilView.Presenter  {

    private static final Auth AUTH = Auth.get();

    private static final String GOOGLE_AUTH_URL = "https://accounts.google.com/o/oauth2/auth";

    // This app's personal client ID assigned by the Google APIs Console
    // (http://code.google.com/apis/console).
    private static final String GOOGLE_CLIENT_ID = "578834462784.apps.googleusercontent.com";

    // The auth scope being requested. This scope will allow the application to
    // identify who the authenticated user is.
    private static final String PLUS_ME_SCOPE = "https://www.googleapis.com/auth/plus.me";

    private AccueilView view = new AccueilViewImpl();

    public AccueilActivity() {

    }


    public void start(AcceptsOneWidget display, EventBus eventBus) {

        view.setPresenter(this);
        display.setWidget(view);
    }

    public void goTo(Place place) {
        OAuth.getPlaceController().goTo(place);
    }

    public void doGoogleAuthent() {
        final AuthRequest req = new AuthRequest(GOOGLE_AUTH_URL, GOOGLE_CLIENT_ID)
                .withScopes(PLUS_ME_SCOPE);

        // Calling login() will display a popup to the user the first time it is
        // called. Once the user has granted access to the application,
        // subsequent calls to login() will not display the popup, and will
        // immediately result in the callback being given the token to use.
        AUTH.login(req, new Callback<String, Throwable>() {

            public void onSuccess(String token) {
                view.informMessage("Got an OAuth token:\n" + token + "\n"
                        + "Token expires in " + AUTH.expiresIn(req) + " ms\n");
            }


            public void onFailure(Throwable caught) {
                view.informMessage("Error:\n" + caught.getMessage());
            }
        });
    }

    public void doClearTokens() {
        Auth.get().clearAllTokens();
        view.informMessage("All tokens cleared");
    }

    public void goSecuredPages() {
        OAuth.getPlaceController().goTo(new AuthenticationPocPlace());
    }
}
