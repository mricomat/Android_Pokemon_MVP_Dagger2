package com.martnrico.pokemon_dagger_mvp.di.module;

import com.martnrico.pokemon_dagger_mvp.data.network.PokemonService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@Module
public class PokemonServiceModule {

    @Provides
    @Singleton
    static PokemonService providePokemonService(Retrofit retrofit) {
        return retrofit.create(PokemonService.class);
    }

    @Provides
    @Named("network_scheduler")
    static Scheduler provideNetworkScheduler() {
        return Schedulers.io();
    }
}
