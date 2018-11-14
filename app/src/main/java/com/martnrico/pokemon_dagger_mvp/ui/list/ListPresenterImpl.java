package com.martnrico.pokemon_dagger_mvp.ui.list;

import com.martnrico.pokemon_dagger_mvp.data.DataManager;
import com.martnrico.pokemon_dagger_mvp.utils.DisposableManager;
import com.martnrico.pokemon_dagger_mvp.data.model.DataContainerListModel;
import com.martnrico.pokemon_dagger_mvp.data.model.DataContainerModel;
import com.martnrico.pokemon_dagger_mvp.di.ScreenScope;
import com.martnrico.pokemon_dagger_mvp.ui.ScreenNavigator;
import com.martnrico.pokemon_dagger_mvp.ui.base.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@ScreenScope
public class ListPresenterImpl<V extends ListView> extends BasePresenterImpl<V> implements ListPresenter<V> {

    private ScreenNavigator mScreenNavigator;

    @Inject
    public ListPresenterImpl(DisposableManager disposableManager, DataManager dataManager,
                             ScreenNavigator screenNavigator) {
        super(dataManager, disposableManager);
        this.mScreenNavigator = screenNavigator;
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
        loadPokemon();
    }

    @Override
    public void loadPokemon() {
        getDisposableManager().add(getDataManager().getPokemonNames(150)
                .doOnSubscribe(disposable -> getMvpView().showLoading())
                .doOnEvent((dataContainerListModel, throwable) -> getMvpView().hideLoading())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataContainerListModel -> getMvpView().showListPokemonNames(
                        getPokemonListFromResults(dataContainerListModel)),
                        throwable -> getMvpView().showError()));
    }

    @Override
    public void onPokemonClicked(String name, Integer id) {
        mScreenNavigator.goToPokemonDetails(name, id);
    }

    private List<String> getPokemonListFromResults(DataContainerListModel dataContainerListModel) {
        List<DataContainerModel> results = dataContainerListModel.getResults();
        List<String> pokemonNames = new ArrayList<>();
        for (DataContainerModel result : results) {
            pokemonNames.add(result.getName().substring(0, 1).toUpperCase() +
                    result.getName().substring(1));
        }
        return pokemonNames;
    }
}
