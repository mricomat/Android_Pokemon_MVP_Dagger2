package com.martnrico.pokemon_dagger_mvp.ui.list;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.martnrico.pokemon_dagger_mvp.R;
import com.martnrico.pokemon_dagger_mvp.ui.base.BaseFragment;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
public class ListViewFragment extends BaseFragment implements ListView {

    static final String INSTANCE_ID = "instance_id";

    @Inject
    ListPresenter<ListView> mPresenter;

    @Inject
    ListAdapter mListAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.linear_layout)
    LinearLayout mLinearLayout;

    public static Fragment newInstance() {
        Bundle bundle = new Bundle();
        bundle.putString(INSTANCE_ID, UUID.randomUUID().toString());
        Fragment fragment = new ListViewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int layoutRes() {
        return R.layout.list_fragment;
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
        initSwipeRefreshLayout();
        initRecyclerView();
    }

    @Override
    protected void setListeners() {
        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.loadPokemon());
    }

    private void initToolbar() {
        if (mToolbar != null) {
            mToolbar.setTitle(getResources().getString(R.string.app_name));
        }
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
    }

    private void initRecyclerView() {
        mRecyclerView.setAdapter(mListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showListPokemonNames(List<String> pokemonNames) {
        mListAdapter.addItems(pokemonNames);
    }

    @Override
    public void showLoading() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError() {
        Snackbar.make(mLinearLayout, getResources().getString(R.string.generic_error), Snackbar.LENGTH_SHORT)
                .setAction(getResources().getString(R.string.generic_retry), v -> mPresenter.loadPokemon()).show();
    }

    @Override
    public void hideError() {

    }
}
