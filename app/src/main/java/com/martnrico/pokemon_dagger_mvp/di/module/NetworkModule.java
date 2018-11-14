package com.martnrico.pokemon_dagger_mvp.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@Module
public class NetworkModule {

    private static final String BASE_URL = "http://pokeapi.co/api/v2/";

    @Provides
    @Named("base_url")
    static String provideBaseUrl() {
        return BASE_URL;
    }

    @Provides
    @Singleton
    static Call.Factory provideOkHttp( ) {
        return new OkHttpClient.Builder()
                .build();
    }
}
