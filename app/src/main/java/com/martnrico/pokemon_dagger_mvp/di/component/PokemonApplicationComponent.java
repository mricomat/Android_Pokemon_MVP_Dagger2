package com.martnrico.pokemon_dagger_mvp.di.component;

import com.martnrico.pokemon_dagger_mvp.PokemonApplication;
import com.martnrico.pokemon_dagger_mvp.di.module.PokemonServiceModule;
import com.martnrico.pokemon_dagger_mvp.di.module.ServiceModule;
import com.martnrico.pokemon_dagger_mvp.di.module.ActivityBindingModule;
import com.martnrico.pokemon_dagger_mvp.di.module.PokemonApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Martín Rico Martínez on 05/11/2018.
 */

@Singleton
@Component(modules = {
        PokemonApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        PokemonServiceModule.class,
})
public interface PokemonApplicationComponent {

    void inject(PokemonApplication pokemonApplication);

}
