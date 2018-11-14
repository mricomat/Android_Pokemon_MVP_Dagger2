package com.martnrico.pokemon_dagger_mvp.ui.details;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.martnrico.pokemon_dagger_mvp.R;
import com.martnrico.pokemon_dagger_mvp.data.model.PokemonModel;
import com.martnrico.pokemon_dagger_mvp.ui.base.BaseFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public class DetailsViewFragment extends BaseFragment implements DetailsView {

    public static final String POKEMON_NAME = "pokemon_name";
    public static final String POKEMON_ID = "pokemon_id";

    @Inject
    DetailsPresenter<DetailsView> mPresenter;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.pokemon_details_layout)
    LinearLayout mPokemonDetailsLayout;

    @BindView(R.id.pokemon_front_image)
    ImageView mPokemonFrontImageView;

    @BindView(R.id.pokemon_back_image)
    ImageView mPokemonBackImageView;

    @BindView(R.id.pokemon_id)
    TextView mPokemonIdTextView;

    @BindView(R.id.pokemon_name)
    TextView mPokemonNameTextView;

    @BindView(R.id.pokemon_height)
    TextView mPokemonHeightTextView;

    @BindView(R.id.pokemon_weight)
    TextView mPokemonWeightTextView;

    @BindView(R.id.pokemon_base_experience)
    TextView mPokemonBaseExperienceTextView;

    @BindView(R.id.pokemon_shiny_text)
    TextView mPokemonShinyText;

    @BindView(R.id.pokemon_shiny_front)
    ImageView mPokemonShinyFront;

    @BindView(R.id.pokemon_shiny_back)
    ImageView mPokemonShinyBack;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static Fragment newInstance(String pokemonName, Integer pokemonId) {
        Bundle bundle = new Bundle();
        bundle.putString(POKEMON_NAME, pokemonName);
        bundle.putInt(POKEMON_ID, pokemonId);
        Fragment fragment = new DetailsViewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int layoutRes() {
        return R.layout.details_fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onAttach(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void onViewBound(View view) {
        initToolbar();
    }

    private void initToolbar() {
        if (mToolbar != null) {
            mToolbar.setTitle(mPresenter.getToolbarTitle());
        }
    }

    @Override
    public void showPokemonDetails(PokemonModel pokemonModel) {
        if(pokemonModel != null) {
            mPokemonIdTextView.setText(getString(R.string.pokemon_id,pokemonModel.getId()));
            mPokemonNameTextView.setText(getString(R.string.pokemon_name,pokemonModel.getName()));
            mPokemonHeightTextView.setText(getString(R.string.pokemon_height,pokemonModel.getHeight()));
            mPokemonWeightTextView.setText(getString(R.string.pokemon_weight,pokemonModel.getWeight()));
            mPokemonBaseExperienceTextView.setText(getString(R.string.pokemon_base_experience,pokemonModel.getBaseExperience()));
            mPokemonShinyText.setText(getString(R.string.pokemon_shiny));

            Picasso.get().load(pokemonModel.getSprites().getFrontDefault()).into(mPokemonFrontImageView);
            Picasso.get().load(pokemonModel.getSprites().getBackDefault()).into(mPokemonBackImageView);
            Picasso.get().load(pokemonModel.getSprites().getFrontShiny()).into(mPokemonShinyFront);
            Picasso.get().load(pokemonModel.getSprites().getBackShiny()).into(mPokemonShinyBack);
        }
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
        mPokemonDetailsLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mPokemonDetailsLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMessage() {
        Snackbar.make(mCoordinatorLayout,getString(R.string.generic_error), Snackbar.LENGTH_SHORT)
                .setAction(getString(R.string.generic_retry), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getPokemonDetails();
                    }
                })
                .show();
    }
}
