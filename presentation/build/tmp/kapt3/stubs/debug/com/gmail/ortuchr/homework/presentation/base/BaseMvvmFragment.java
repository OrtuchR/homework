package com.gmail.ortuchr.homework.presentation.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J\r\u0010\'\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0017J\b\u0010(\u001a\u00020)H&R\u001c\u0010\t\u001a\u00028\u0002X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00018\u0001X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006*"}, d2 = {"Lcom/gmail/ortuchr/homework/presentation/base/BaseMvvmFragment;", "VM", "Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;", "R", "Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "B", "Landroid/databinding/ViewDataBinding;", "Lcom/gmail/ortuchr/homework/presentation/base/BaseFragment;", "()V", "binding", "getBinding", "()Landroid/databinding/ViewDataBinding;", "setBinding", "(Landroid/databinding/ViewDataBinding;)V", "Landroid/databinding/ViewDataBinding;", "router", "getRouter", "()Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "setRouter", "(Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;)V", "Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "viewModel", "getViewModel", "()Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;", "setViewModel", "(Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;)V", "Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "onResume", "prodiveViewModel", "provideLayoutId", "", "presentation_debug"})
public abstract class BaseMvvmFragment<VM extends com.gmail.ortuchr.homework.presentation.base.BaseViewModel<R>, R extends com.gmail.ortuchr.homework.presentation.base.BaseRouter<?>, B extends android.databinding.ViewDataBinding> extends com.gmail.ortuchr.homework.presentation.base.BaseFragment {
    @org.jetbrains.annotations.NotNull()
    protected VM viewModel;
    @org.jetbrains.annotations.NotNull()
    protected B binding;
    @org.jetbrains.annotations.Nullable()
    private R router;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    protected final VM getViewModel() {
        return null;
    }
    
    protected final void setViewModel(@org.jetbrains.annotations.NotNull()
    VM p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final B getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull()
    B p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final R getRouter() {
        return null;
    }
    
    protected final void setRouter(@org.jetbrains.annotations.Nullable()
    R p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract VM prodiveViewModel();
    
    public abstract int provideLayoutId();
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    public BaseMvvmFragment() {
        super();
    }
}