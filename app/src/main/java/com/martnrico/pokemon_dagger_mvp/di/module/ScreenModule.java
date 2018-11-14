package com.martnrico.pokemon_dagger_mvp.di.module;

import com.martnrico.pokemon_dagger_mvp.utils.DisposableManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 08/11/2018.
 */
@Module
public abstract class ScreenModule {

    @Provides
    static DisposableManager provideDisposableManager() {
        return new DisposableManager();
    }
}
