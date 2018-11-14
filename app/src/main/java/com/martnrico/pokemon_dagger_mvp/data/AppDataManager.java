package com.martnrico.pokemon_dagger_mvp.data;

import com.martnrico.pokemon_dagger_mvp.data.model.DataContainerListModel;
import com.martnrico.pokemon_dagger_mvp.data.model.PokemonModel;
import com.martnrico.pokemon_dagger_mvp.data.network.PokemonApiHelper;
import com.martnrico.pokemon_dagger_mvp.data.network.PokemonService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by Martín Rico Martínez on 13/11/2018.
 */
@Singleton
public class AppDataManager implements DataManager {

    private final PokemonApiHelper mPokemonApiHelper;
    // TODO PreferencesHelper
    // TODO DBHelper

    @Inject
    public AppDataManager(PokemonApiHelper pokemonApiHelper) {
        this.mPokemonApiHelper = pokemonApiHelper;
    }

    @Override
    public Single<DataContainerListModel> getPokemonNames(Integer limit) {
        return mPokemonApiHelper.getPokemonNames(limit);
    }

    @Override
    public Single<PokemonModel> getPokemonDetails(Integer id) {
        return mPokemonApiHelper.getPokemonDetails(id);
    }
}
