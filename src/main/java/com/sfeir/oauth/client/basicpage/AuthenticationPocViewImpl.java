package com.sfeir.oauth.client.basicpage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AuthenticationPocViewImpl extends Composite implements AuthenticationPocActivity.AuthenticationPocView
{
    interface AuthenticationPocViewImplUiBinder extends UiBinder<Widget, AuthenticationPocViewImpl> {
    }

    private static AuthenticationPocViewImplUiBinder uiBinder = GWT
            .create(AuthenticationPocViewImplUiBinder.class);

    public AuthenticationPocViewImpl(){

        initWidget(uiBinder.createAndBindUi(this));
    }
}