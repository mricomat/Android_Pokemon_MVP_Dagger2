package com.martnrico.pokemon_dagger_mvp;

import android.app.Application;


import com.martnrico.pokemon_dagger_mvp.di.component.DaggerPokemonApplicationComponent;
import com.martnrico.pokemon_dagger_mvp.di.component.PokemonApplicationComponent;
import com.martnrico.pokemon_dagger_mvp.di.injector.ActivityInjector;
import com.martnrico.pokemon_dagger_mvp.di.module.PokemonApplicationModule;

import javax.inject.Inject;

/**
 * Created by Martín Rico Martínez on 05/11/2018.
 */
public class PokemonApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private PokemonApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = initComponent();
        mComponent.inject(this);
    }

    protected PokemonApplicationComponent initComponent() {
        return mComponent = DaggerPokemonApplicationComponent.builder()
                .pokemonApplicationModule(new PokemonApplicationModule(this))
                .build();
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
