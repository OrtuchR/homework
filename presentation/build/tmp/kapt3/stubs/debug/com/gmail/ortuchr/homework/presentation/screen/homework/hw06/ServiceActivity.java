package com.gmail.ortuchr.homework.presentation.screen.homework.hw06;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0004\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0014R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw06/ServiceActivity;", "Landroid/app/Activity;", "()V", "localMessageReceiver", "com/gmail/ortuchr/homework/presentation/screen/homework/hw06/ServiceActivity$localMessageReceiver$1", "Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw06/ServiceActivity$localMessageReceiver$1;", "mConnection", "com/gmail/ortuchr/homework/presentation/screen/homework/hw06/ServiceActivity$mConnection$1", "Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw06/ServiceActivity$mConnection$1;", "mService", "Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw06/WifiService;", "startServiceButton", "Landroid/widget/Button;", "startServiceButtonOff", "", "startServiceButtonOn", "statusConnection", "", "statusWiFiGoingOff", "statusWiFiGoingOn", "statusWiFiOff", "statusWiFiOn", "statusWiFiTextView", "Landroid/widget/TextView;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "presentation_debug"})
public final class ServiceActivity extends android.app.Activity {
    private com.gmail.ortuchr.homework.presentation.screen.homework.hw06.WifiService mService;
    private boolean statusConnection;
    private java.lang.String startServiceButtonOn;
    private java.lang.String startServiceButtonOff;
    private java.lang.String statusWiFiOn;
    private java.lang.String statusWiFiGoingOn;
    private java.lang.String statusWiFiOff;
    private java.lang.String statusWiFiGoingOff;
    private android.widget.Button startServiceButton;
    private android.widget.TextView statusWiFiTextView;
    private final android.content.ServiceConnection mConnection = null;
    private final android.content.BroadcastReceiver localMessageReceiver = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public ServiceActivity() {
        super();
    }
}