package com.martnrico.pokemon_dagger_mvp.data.network;

import com.martnrico.pokemon_dagger_mvp.data.model.DataContainerListModel;
import com.martnrico.pokemon_dagger_mvp.data.model.PokemonModel;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.Single;


/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@Singleton
public class PokemonApiHelper {

    private final PokemonService service;
    private final Scheduler scheduler;

    @Inject
    PokemonApiHelper(PokemonService service, @Named("network_scheduler") Scheduler scheduler) {
        this.service = service;
        this.scheduler = scheduler;
    }

    public Single<DataContainerListModel> getPokemonNames(Integer limit) {
        return service.getPokemonNames(limit).subscribeOn(scheduler);
    }

    public Single<PokemonModel> getPokemonDetails(Integer id) {
        return service.getPokemonDetails(id).subscribeOn(scheduler);
    }
}
