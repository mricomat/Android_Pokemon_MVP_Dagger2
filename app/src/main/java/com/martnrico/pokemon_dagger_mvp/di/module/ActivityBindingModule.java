package com.martnrico.pokemon_dagger_mvp.di.module;

import com.martnrico.pokemon_dagger_mvp.di.ActivityScope;
import com.martnrico.pokemon_dagger_mvp.ui.home.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Martín Rico Martínez on 05/11/2018.
 */

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {
            MainScreenBindingModule.class,
            NavigationModule.class,
            ScreenModule.class,
    })
    @ActivityScope
    abstract MainActivity provideMainActivityInjector();

}
