package com.martnrico.pokemon_dagger_mvp.ui.details;

import com.martnrico.pokemon_dagger_mvp.data.DataManager;
import com.martnrico.pokemon_dagger_mvp.utils.DisposableManager;
import com.martnrico.pokemon_dagger_mvp.data.model.PokemonModel;
import com.martnrico.pokemon_dagger_mvp.di.ScreenScope;
import com.martnrico.pokemon_dagger_mvp.ui.base.BasePresenterImpl;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@ScreenScope
public class DetailsPresenterImpl<V extends DetailsView> extends BasePresenterImpl<V> implements DetailsPresenter<V>{

    private final static String TOOLBAR_TITLE_FORMAT = "%s (#%s)";

    private String mPokemonName;
    private Integer mPokemonId;

    @Inject
    DetailsPresenterImpl(@Named("pokemon_name") String pokemonName, @Named("pokemon_id") Integer pokemonId,
                         DisposableManager disposableManager, DataManager dataManager) {
        super(dataManager, disposableManager);
        this.mPokemonName = pokemonName;
        this.mPokemonId = pokemonId;
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
        getPokemonDetails();
    }

    @Override
    public void getPokemonDetails() {
        getDisposableManager().add(getDataManager().getPokemonDetails(mPokemonId)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        getMvpView().showLoading();
                    }
                })
                .doOnEvent(new BiConsumer<PokemonModel, Throwable>() {
                    @Override
                    public void accept(PokemonModel pokemonModel, Throwable throwable) throws Exception {
                        getMvpView().hideLoading();
                    }
                })
                .subscribe(pokemonModel -> getMvpView().showPokemonDetails(pokemonModel),
                        throwable -> getMvpView().showErrorMessage()));
    }

    @Override
    public String getToolbarTitle() {
        return String.format(TOOLBAR_TITLE_FORMAT, mPokemonName, mPokemonId);
    }
}
