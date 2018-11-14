package com.martnrico.pokemon_dagger_mvp.ui.base;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public interface BasePresenter<V> {

    void onAttach(V view);

    void onDetach();

}
