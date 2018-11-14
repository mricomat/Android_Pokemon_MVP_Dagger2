package com.martnrico.pokemon_dagger_mvp.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.martnrico.pokemon_dagger_mvp.R;
import com.martnrico.pokemon_dagger_mvp.ui.ScreenNavigator;
import com.martnrico.pokemon_dagger_mvp.di.injector.Injector;
import com.martnrico.pokemon_dagger_mvp.di.injector.ScreenInjector;

import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by Martín Rico Martínez on 05/11/2018.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static String INSTANCE_ID_KEY = "instance_id";

    @Inject ScreenInjector screenInjector;
    @Inject ScreenNavigator screenNavigator;

    private String mInstanceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mInstanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            mInstanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(layoutRes());

        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if (screenContainer == null) {
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }

        screenNavigator.init(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(INSTANCE_ID_KEY, mInstanceId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Injector.clearComponent(this);
        }
        screenNavigator.onDestroy(this);
    }

    @Override
    public void onBackPressed() {
        if(!screenNavigator.pop()) {
            super.onBackPressed();
        }
    }

    @LayoutRes
    protected abstract int layoutRes();

    public String getInstanceId() {
        return this.mInstanceId;
    }

    public ScreenInjector getScreenInjector() {
        return screenInjector;
    }
}
