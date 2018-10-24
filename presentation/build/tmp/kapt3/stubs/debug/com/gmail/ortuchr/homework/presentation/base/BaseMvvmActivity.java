package com.gmail.ortuchr.homework.presentation.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007B\u0005\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\"H&J\r\u0010#\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010\u0011J\r\u0010$\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0017R\u001c\u0010\t\u001a\u00028\u0002X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00028\u0001X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/gmail/ortuchr/homework/presentation/base/BaseMvvmActivity;", "VM", "Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;", "R", "Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "B", "Landroid/databinding/ViewDataBinding;", "Lcom/gmail/ortuchr/homework/presentation/base/BaseActivity;", "()V", "binding", "getBinding", "()Landroid/databinding/ViewDataBinding;", "setBinding", "(Landroid/databinding/ViewDataBinding;)V", "Landroid/databinding/ViewDataBinding;", "router", "getRouter", "()Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "setRouter", "(Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;)V", "Lcom/gmail/ortuchr/homework/presentation/base/BaseRouter;", "viewModel", "getViewModel", "()Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;", "setViewModel", "(Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;)V", "Lcom/gmail/ortuchr/homework/presentation/base/BaseViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "provideLayoutId", "", "provideRouter", "provideViewModel", "presentation_debug"})
public abstract class BaseMvvmActivity<VM extends com.gmail.ortuchr.homework.presentation.base.BaseViewModel<R>, R extends com.gmail.ortuchr.homework.presentation.base.BaseRouter<?>, B extends android.databinding.ViewDataBinding> extends com.gmail.ortuchr.homework.presentation.base.BaseActivity {
    @org.jetbrains.annotations.NotNull()
    protected VM viewModel;
    @org.jetbrains.annotations.NotNull()
    protected B binding;
    @org.jetbrains.annotations.NotNull()
    public R router;
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
    
    @org.jetbrains.annotations.NotNull()
    public final R getRouter() {
        return null;
    }
    
    public final void setRouter(@org.jetbrains.annotations.NotNull()
    R p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract VM provideViewModel();
    
    @org.jetbrains.annotations.NotNull()
    public abstract R provideRouter();
    
    public abstract int provideLayoutId();
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    public BaseMvvmActivity() {
        super();
    }
}