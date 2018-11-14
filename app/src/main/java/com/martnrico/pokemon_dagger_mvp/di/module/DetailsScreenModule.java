package com.martnrico.pokemon_dagger_mvp.di.module;

import com.martnrico.pokemon_dagger_mvp.ui.details.DetailsPresenter;
import com.martnrico.pokemon_dagger_mvp.ui.details.DetailsPresenterImpl;
import com.martnrico.pokemon_dagger_mvp.ui.details.DetailsView;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@Module
public class DetailsScreenModule {

    @Provides
    DetailsPresenter<DetailsView> bindDetailsPresenter(DetailsPresenterImpl<DetailsView> presenter) {
        return presenter;
    }
}
