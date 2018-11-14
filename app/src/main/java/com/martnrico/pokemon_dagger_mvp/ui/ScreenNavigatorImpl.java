package com.martnrico.pokemon_dagger_mvp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.martnrico.pokemon_dagger_mvp.R;
import com.martnrico.pokemon_dagger_mvp.di.ActivityScope;
import com.martnrico.pokemon_dagger_mvp.ui.details.DetailsViewFragment;
import com.martnrico.pokemon_dagger_mvp.ui.list.ListViewFragment;

import javax.inject.Inject;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@ActivityScope
public class ScreenNavigatorImpl implements ScreenNavigator{

    private FragmentManager mFragmentManager;

    @Inject
    ScreenNavigatorImpl() {

    }

    @Override
    public void init(AppCompatActivity activity) {
        this.mFragmentManager = activity.getSupportFragmentManager();
        Fragment fragment = ListViewFragment.newInstance();
        if(mFragmentManager.getFragments().size() == 0) {
            mFragmentManager.beginTransaction()
                    .replace(R.id.screen_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean pop() {
        return mFragmentManager != null && mFragmentManager.popBackStackImmediate();
    }

    @Override
    public void goToPokemonDetails(String name, Integer id) {
        if (mFragmentManager != null) {
            mFragmentManager.beginTransaction()
                    .replace(R.id.screen_container, DetailsViewFragment.newInstance(name, id))
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onDestroy(AppCompatActivity activity) {
        mFragmentManager = null;
    }
}
