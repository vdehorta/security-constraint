package com.sfeir.oauth.client.accueil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AccueilViewImpl extends Composite implements AccueilView
{

    interface AccueilViewImplUiBinder extends UiBinder<Widget, AccueilViewImpl> {
    }

    private Presenter presenter;

    private static AccueilViewImplUiBinder uiBinder = GWT
            .create(AccueilViewImplUiBinder.class);

    @UiField
    protected Button btnGoogleAuth;

    @UiField
    protected Button btnClearTokens;

    @UiField
    protected Anchor backSecuredPagesLink;

    public AccueilViewImpl(){

        initWidget(uiBinder.createAndBindUi(this));


    }

    @UiHandler("btnGoogleAuth")
    public void clickBtnGoogleAuth(final ClickEvent event) {
        this.presenter.doGoogleAuthent();
    }

    @UiHandler("btnClearTokens")
    public void clickBtnClearTokens(final ClickEvent event) {
        this.presenter.doClearTokens();
    }

    @UiHandler("backSecuredPagesLink")
    public void clickBackSecuredPagesLink(final ClickEvent event) {
        this.presenter.goSecuredPages();
    }

    public void setPresenter(Presenter listener) {
        this.presenter = listener;
    }

    public void informMessage(String s) {
        Window.alert(s);
    }
}