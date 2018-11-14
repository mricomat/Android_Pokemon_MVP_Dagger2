package com.martnrico.pokemon_dagger_mvp.di.module;

import com.martnrico.pokemon_dagger_mvp.ui.ScreenNavigator;
import com.martnrico.pokemon_dagger_mvp.ui.ScreenNavigatorImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(ScreenNavigatorImpl screenNavigator);

}
