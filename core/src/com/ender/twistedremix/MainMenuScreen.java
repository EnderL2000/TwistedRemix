package com.ender.twistedremix;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ender.twistedremix.TwistedUtil.TwistedScreen;

public class MainMenuScreen implements TwistedScreen {

    public final TwistedRemix game;

    public Stage stage;

    int width, height;

    private Music menuTheme;

    private Sound boom;

    private OrthographicCamera menuCamera;

    public MainMenuScreen(final TwistedRemix game) {
        this.game = game;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        menuTheme = Gdx.audio.newMusic(Gdx.files.internal("Music/MenuTheme.mp3"));
        menuTheme.setLooping(true);
        menuTheme.play();

        boom = Gdx.audio.newSound(Gdx.files.internal("SFX/menuToGameScreenTransition.mp3"));

        menuCamera = new OrthographicCamera();
        menuCamera.setToOrtho(false, 1920, 1080);//stage.getWidth(), stage.getHeight());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

        menuCamera.update();

        stage.getBatch().begin();

        stage.getBatch().setProjectionMatrix(menuCamera.combined);
        stage.getBatch().draw(new Texture(Gdx.files.internal("Images/Space Hexagons.jpg")), 0, 0);
        game.font.draw(stage.getBatch(), "Welcome to Twisted Remix", 500, 200);
        game.font.draw(stage.getBatch(), "Click anywhere to continue", 1910, 1070);

        stage.getBatch().end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game)); //TODO fade to next Screen
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        menuTheme.dispose();
        stage.dispose();
        boom.dispose();
    }

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
