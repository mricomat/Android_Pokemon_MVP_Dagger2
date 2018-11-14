package com.martnrico.pokemon_dagger_mvp.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martnrico.pokemon_dagger_mvp.di.injector.Injector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Martín Rico Martínez on 05/11/2018.
 */
public abstract class BaseFragment extends Fragment implements BaseView{

    private Unbinder unbinder;

    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    public void onAttach(Context context) {
        Injector.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(layoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        setListeners();
        onViewBound(view);
        disposables.addAll(subscriptions());
        return view;
    }

    @Override
    public void onDestroyView() {
        disposables.clear();
        if(unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!getActivity().isChangingConfigurations()) {
            Injector.clearComponent(this);
        }
    }

    protected void onViewBound(View view) {

    }

    protected void setListeners() {

    }

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }

    @LayoutRes
    protected abstract int layoutRes();
}
