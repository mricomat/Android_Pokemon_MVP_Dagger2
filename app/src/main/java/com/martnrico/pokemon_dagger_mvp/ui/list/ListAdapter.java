package com.martnrico.pokemon_dagger_mvp.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martnrico.pokemon_dagger_mvp.R;

import java.util.List;

/**
 * Created by Martín Rico Martínez on 07/11/2018.
 */
public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<String> mPokemonNames;
    private ListPresenter<ListView> mPresenter;

    public ListAdapter(List<String> pokemonListNames, ListPresenter<ListView> presenter) {
        mPokemonNames = pokemonListNames;
        mPresenter = presenter;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ListViewHolder(view, mPresenter);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        if(mPokemonNames != null && !mPokemonNames.isEmpty()) {
            holder.onBind(mPokemonNames.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        if(mPokemonNames != null && mPokemonNames.size() > 0) {
            return mPokemonNames.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<String> pokemonNames) {
        mPokemonNames.addAll(pokemonNames);
        notifyDataSetChanged();
    }
}
