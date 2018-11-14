package com.martnrico.pokemon_dagger_mvp.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.martnrico.pokemon_dagger_mvp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martín Rico Martínez on 07/11/2018.
 */
public class ListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.pokemon_name)
    TextView mPokemonNameText;

    private ListPresenter<ListView> mPresenter;

    public ListViewHolder(View itemView, ListPresenter<ListView> presenter) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mPresenter = presenter;
    }

    private void clear() {
        mPokemonNameText.setText("");
    }

    public void onBind(final String name, final Integer position) {
        clear();
        mPokemonNameText.setText(name);
        itemView.setOnClickListener(v -> mPresenter.onPokemonClicked(name, position + 1));
    }
}
