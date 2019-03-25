# Android_Pokemon_MVP_Java

This repository contains a detailed basic example app that implements MVP arquitecture using Dagger2, RxJava and Retrofit. The theme that I have chosen is that of a very basic pokedex.

I have already reimplemented the dispatching Android injector of Dagger2. The difference is that before calling inject we're going to cache it. Then before creating a new injector we're going to check if it's in the cache. You can see it in the folder "Injection".

# Screens
<img src = "https://user-images.githubusercontent.com/35971408/48472104-c7ce7400-e7f5-11e8-9248-7f9633fd8aa8.png" width="250"> <img src = "https://user-images.githubusercontent.com/35971408/48472147-e03e8e80-e7f5-11e8-8938-614cdaaaa904.png" width="250">

# Arquitecture
![pokemon_mvp_arquitecture](https://user-images.githubusercontent.com/35971408/48472913-948ce480-e7f7-11e8-9ff1-7606cb843740.jpg)


# Project Structure
<img src = "https://user-images.githubusercontent.com/35971408/48477970-45e54780-e803-11e8-8f3c-5b3536c7326d.png">
<br>

## Library reference resources:
1. RxJava2: https://github.com/ReactiveX/RxJava
2. Dagger2: https://github.com/google/dagger
3. Retrofit: https://square.github.io/retrofit/
4. Picasso: http://square.github.io/picasso/
5. ButterKnife: http://jakewharton.github.io/butterknife/
