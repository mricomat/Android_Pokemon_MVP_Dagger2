package com.martnrico.pokemon_dagger_mvp.di.component;

import com.martnrico.pokemon_dagger_mvp.utils.DisposableManager;

import dagger.android.AndroidInjector;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public interface ScreenComponent<T> extends AndroidInjector<T> {

    DisposableManager disposableManager();

}
