package com.martnrico.pokemon_dagger_mvp.di.component;

import com.martnrico.pokemon_dagger_mvp.di.module.DetailsScreenModule;
import com.martnrico.pokemon_dagger_mvp.di.module.ScreenModule;
import com.martnrico.pokemon_dagger_mvp.di.ScreenScope;
import com.martnrico.pokemon_dagger_mvp.ui.details.DetailsViewFragment;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Martín Rico Martínez on 12/11/2018.
 */
@ScreenScope
@Subcomponent(modules = {
        ScreenModule.class,
        DetailsScreenModule.class,
})
public interface DetailsComponent extends ScreenComponent<DetailsViewFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailsViewFragment> {

        @BindsInstance
        public abstract void bindPokemonName(@Named("pokemon_name") String pokemonName);

        @BindsInstance
        public abstract void bindPokemonId(@Named("pokemon_id") Integer pokemonId);

        @Override
        public void seedInstance(DetailsViewFragment instance) {
            bindPokemonName(instance.getArguments().getString(DetailsViewFragment.POKEMON_NAME));
            bindPokemonId(instance.getArguments().getInt(DetailsViewFragment.POKEMON_ID));
        }
    }
}
