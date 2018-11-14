package com.martnrico.pokemon_dagger_mvp.data.network;

import com.martnrico.pokemon_dagger_mvp.data.model.DataContainerListModel;
import com.martnrico.pokemon_dagger_mvp.data.model.DataContainerModel;
import com.martnrico.pokemon_dagger_mvp.data.model.PokemonModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public interface PokemonService {

    @GET("pokemon")
    Single<DataContainerListModel> getPokemonNames(@Query("limit") Integer limit);

    @GET("pokemon/{id}")
    Single<PokemonModel> getPokemonDetails(@Path("id") Integer id);

}
