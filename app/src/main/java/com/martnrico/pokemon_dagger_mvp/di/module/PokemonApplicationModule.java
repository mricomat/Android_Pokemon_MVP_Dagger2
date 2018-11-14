package com.martnrico.pokemon_dagger_mvp.di.module;

import android.app.Application;
import android.content.Context;

import com.martnrico.pokemon_dagger_mvp.data.AppDataManager;
import com.martnrico.pokemon_dagger_mvp.data.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 05/11/2018.
 */

@Module
public class PokemonApplicationModule {

    private Application application;

    public PokemonApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }
}
