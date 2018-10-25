package com.gmail.ortuchr.homework.databinding;
import com.gmail.ortuchr.homework.R;
import com.gmail.ortuchr.homework.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityTimerRxBindingImpl extends ActivityTimerRxBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener timerCheckBoxandroidCheckedAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.isOnlyEven().get()
            //         is viewModel.isOnlyEven().set((boolean) callbackArg_0)
            boolean callbackArg_0 = timerCheckBox.isChecked();
            // localize variables for thread safety
            // viewModel.isOnlyEven().get()
            boolean viewModelIsOnlyEvenGet = false;
            // viewModel.isOnlyEven()
            android.databinding.ObservableBoolean viewModelIsOnlyEven = null;
            // viewModel
            com.gmail.ortuchr.homework.presentation.screen.homework.hw09.TimerRxViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.isOnlyEven() != null
            boolean viewModelIsOnlyEvenJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelIsOnlyEven = viewModel.isOnlyEven();

                viewModelIsOnlyEvenJavaLangObjectNull = (viewModelIsOnlyEven) != (null);
                if (viewModelIsOnlyEvenJavaLangObjectNull) {




                    viewModelIsOnlyEven.set(((boolean) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityTimerRxBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ActivityTimerRxBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.CheckBox) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.timerCheckBox.setTag(null);
        this.timerTextView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.gmail.ortuchr.homework.presentation.screen.homework.hw09.TimerRxViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.gmail.ortuchr.homework.presentation.screen.homework.hw09.TimerRxViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelIsOnlyEven((android.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeViewModelTimerTextView((android.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsOnlyEven(android.databinding.ObservableBoolean ViewModelIsOnlyEven, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelTimerTextView(android.databinding.ObservableField<java.lang.String> ViewModelTimerTextView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean viewModelIsOnlyEvenGet = false;
        android.databinding.ObservableBoolean viewModelIsOnlyEven = null;
        java.lang.String viewModelTimerTextViewGet = null;
        android.databinding.ObservableField<java.lang.String> viewModelTimerTextView = null;
        com.gmail.ortuchr.homework.presentation.screen.homework.hw09.TimerRxViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isOnlyEven()
                        viewModelIsOnlyEven = viewModel.isOnlyEven();
                    }
                    updateRegistration(0, viewModelIsOnlyEven);


                    if (viewModelIsOnlyEven != null) {
                        // read viewModel.isOnlyEven().get()
                        viewModelIsOnlyEvenGet = viewModelIsOnlyEven.get();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.timerTextView
                        viewModelTimerTextView = viewModel.getTimerTextView();
                    }
                    updateRegistration(1, viewModelTimerTextView);


                    if (viewModelTimerTextView != null) {
                        // read viewModel.timerTextView.get()
                        viewModelTimerTextViewGet = viewModelTimerTextView.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            android.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.timerCheckBox, viewModelIsOnlyEvenGet);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            android.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.timerCheckBox, (android.widget.CompoundButton.OnCheckedChangeListener)null, timerCheckBoxandroidCheckedAttrChanged);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.timerTextView, viewModelTimerTextViewGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isOnlyEven()
        flag 1 (0x2L): viewModel.timerTextView
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}