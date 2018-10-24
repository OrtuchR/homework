package com.gmail.ortuchr.homework.presentation.screen.homework.hw_06;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\n\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u0012\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw_06/WifiService;", "Landroid/app/Service;", "()V", "changeWiFiIntent", "Landroid/content/Intent;", "mBinder", "Landroid/os/IBinder;", "manager", "Landroid/net/wifi/WifiManager;", "statusWiFi", "com/gmail/ortuchr/homework/presentation/screen/homework/hw_06/WifiService$statusWiFi$1", "Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw_06/WifiService$statusWiFi$1;", "changeWiFiState", "", "onBind", "intent", "onUnbind", "", "sendLocalMessage", "LocalBinder", "presentation_debug"})
public final class WifiService extends android.app.Service {
    private final android.os.IBinder mBinder = null;
    private android.net.wifi.WifiManager manager;
    private final android.content.Intent changeWiFiIntent = null;
    private final android.content.BroadcastReceiver statusWiFi = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public boolean onUnbind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return false;
    }
    
    public final void changeWiFiState() {
    }
    
    public final void sendLocalMessage() {
    }
    
    public WifiService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw_06/WifiService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw_06/WifiService;)V", "getService", "Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw_06/WifiService;", "presentation_debug"})
    public final class LocalBinder extends android.os.Binder {
        
        @org.jetbrains.annotations.NotNull()
        public final com.gmail.ortuchr.homework.presentation.screen.homework.hw_06.WifiService getService() {
            return null;
        }
        
        public LocalBinder() {
            super();
        }
    }
}