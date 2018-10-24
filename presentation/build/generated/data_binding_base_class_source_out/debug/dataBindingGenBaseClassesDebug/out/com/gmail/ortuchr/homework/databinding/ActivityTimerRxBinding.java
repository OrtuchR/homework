package com.gmail.ortuchr.homework.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gmail.ortuchr.homework.presentation.screen.homework.hw_09.TimerRxViewModel;

public abstract class ActivityTimerRxBinding extends ViewDataBinding {
  @NonNull
  public final TextView timerTextView;

  @Bindable
  protected TimerRxViewModel mViewModel;

  protected ActivityTimerRxBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView timerTextView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.timerTextView = timerTextView;
  }

  public abstract void setViewModel(@Nullable TimerRxViewModel viewModel);

  @Nullable
  public TimerRxViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ActivityTimerRxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTimerRxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTimerRxBinding>inflate(inflater, com.gmail.ortuchr.homework.R.layout.activity_timer_rx, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTimerRxBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTimerRxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTimerRxBinding>inflate(inflater, com.gmail.ortuchr.homework.R.layout.activity_timer_rx, null, false, component);
  }

  public static ActivityTimerRxBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityTimerRxBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityTimerRxBinding)bind(component, view, com.gmail.ortuchr.homework.R.layout.activity_timer_rx);
  }
}
