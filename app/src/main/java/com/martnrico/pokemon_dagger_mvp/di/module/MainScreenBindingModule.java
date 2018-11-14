package com.martnrico.pokemon_dagger_mvp.di.module;


import android.support.v4.app.Fragment;

import com.martnrico.pokemon_dagger_mvp.di.component.DetailsComponent;
import com.martnrico.pokemon_dagger_mvp.di.ScreenScope;
import com.martnrico.pokemon_dagger_mvp.ui.details.DetailsViewFragment;
import com.martnrico.pokemon_dagger_mvp.ui.list.ListViewFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Martín Rico Martínez on 06/11/2018.
 */
@Module(subcomponents = {
        DetailsComponent.class,
})
public abstract class MainScreenBindingModule {

    @ContributesAndroidInjector(modules = {
            ListScreenModule.class,
            ScreenModule.class,
    })
    @ScreenScope
    abstract ListViewFragment bindListViewFragmentInjector();

   @Binds
   @IntoMap
   @FragmentKey(DetailsViewFragment.class)
   abstract AndroidInjector.Factory<? extends Fragment> bindDetailsInjector(DetailsComponent.Builder builder);
}
