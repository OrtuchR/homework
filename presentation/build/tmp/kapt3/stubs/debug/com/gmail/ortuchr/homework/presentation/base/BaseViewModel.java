package com.gmail.ortuchr.homework.presentation.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0004J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\u0006\u0010\u0017\u001a\u00020\u0012R\u001b\u0010\u0005\u001a\u00020\u00068DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;", "R", "Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "Landroid/arch/lifecycle/ViewModel;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "router", "getRouter", "()Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "setRouter", "(Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;)V", "Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "addRouter", "", "addToDisposable", "disposable", "Lio/reactivex/disposables/Disposable;", "onCleared", "removeRouter", "presentation_debug"})
public abstract class BaseViewModel<R extends com.gmail.ortuchr.homework.presentation.base.BaseRouter<?>> extends android.arch.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable()
    private R router;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy compositeDisposable$delegate = null;
    
    @org.jetbrains.annotations.Nullable()
    protected final R getRouter() {
        return null;
    }
    
    protected final void setRouter(@org.jetbrains.annotations.Nullable()
    R p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final io.reactivex.disposables.CompositeDisposable getCompositeDisposable() {
        return null;
    }
    
    public final void addRouter(@org.jetbrains.annotations.Nullable()
    R router) {
    }
    
    public final void removeRouter() {
    }
    
    protected final void addToDisposable(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable disposable) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public BaseViewModel() {
        super();
    }
}