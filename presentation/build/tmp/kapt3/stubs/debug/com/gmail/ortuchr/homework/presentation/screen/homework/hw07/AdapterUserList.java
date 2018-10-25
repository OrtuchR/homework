package com.gmail.ortuchr.homework.presentation.screen.homework.hw07;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw07/AdapterUserList;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw07/AdapterUserList$MyViewHolder;", "onItemClick", "Lkotlin/Function1;", "Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw07/User;", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "value", "", "userListDataSet", "getUserListDataSet", "()Ljava/util/List;", "setUserListDataSet", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "MyViewHolder", "presentation_debug"})
public final class AdapterUserList extends android.support.v7.widget.RecyclerView.Adapter<com.gmail.ortuchr.homework.presentation.screen.homework.hw07.AdapterUserList.MyViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.gmail.ortuchr.homework.presentation.screen.homework.hw07.User> userListDataSet;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.gmail.ortuchr.homework.presentation.screen.homework.hw07.User, kotlin.Unit> onItemClick;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.gmail.ortuchr.homework.presentation.screen.homework.hw07.User> getUserListDataSet() {
        return null;
    }
    
    public final void setUserListDataSet(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gmail.ortuchr.homework.presentation.screen.homework.hw07.User> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.gmail.ortuchr.homework.presentation.screen.homework.hw07.AdapterUserList.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int position) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.gmail.ortuchr.homework.presentation.screen.homework.hw07.AdapterUserList.MyViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.gmail.ortuchr.homework.presentation.screen.homework.hw07.User, kotlin.Unit> getOnItemClick() {
        return null;
    }
    
    public final void setOnItemClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gmail.ortuchr.homework.presentation.screen.homework.hw07.User, kotlin.Unit> p0) {
    }
    
    public AdapterUserList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gmail.ortuchr.homework.presentation.screen.homework.hw07.User, kotlin.Unit> onItemClick) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw07/AdapterUserList$MyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/gmail/ortuchr/homework/presentation/screen/homework/hw07/AdapterUserList;Landroid/view/View;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textSurname", "getTextSurname", "userPicture", "Landroid/widget/ImageView;", "getUserPicture", "()Landroid/widget/ImageView;", "presentation_debug"})
    public final class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView textName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView textSurname = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView userPicture = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ProgressBar progressBar = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTextName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTextSurname() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getUserPicture() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ProgressBar getProgressBar() {
            return null;
        }
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}