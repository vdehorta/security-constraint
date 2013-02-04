package com.sfeir.oauth.client.basicpage;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public class AuthenticationPocActivity extends AbstractActivity {

    public interface AuthenticationPocView extends IsWidget {
    }

    private AuthenticationPocView view = new AuthenticationPocViewImpl();

    public AuthenticationPocActivity() {

    }


    public void start(AcceptsOneWidget display, EventBus eventBus) {

        display.setWidget(view);
    }
}
