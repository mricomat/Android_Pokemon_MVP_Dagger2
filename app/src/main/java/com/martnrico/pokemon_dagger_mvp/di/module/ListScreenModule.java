package com.martnrico.pokemon_dagger_mvp.di.module;

import com.martnrico.pokemon_dagger_mvp.ui.list.ListAdapter;
import com.martnrico.pokemon_dagger_mvp.ui.list.ListPresenter;
import com.martnrico.pokemon_dagger_mvp.ui.list.ListPresenterImpl;
import com.martnrico.pokemon_dagger_mvp.ui.list.ListView;

import java.util.ArrayList;
import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@Module
public class ListScreenModule {

    @Provides
    ListPresenter<ListView> bindListPresenter(ListPresenterImpl<ListView> presenter) {
        return presenter;
    }

    @Provides
    ListAdapter provideListAdapter(ListPresenter<ListView> presenter) {
        return new ListAdapter(new ArrayList<String>(), presenter);
    }

}
