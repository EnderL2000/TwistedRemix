package com.ender.twistedremix;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ender.twistedremix.TwistedUtil.TwistedScreen;
import com.ender.twistedremix.board.BoardPanel;
import com.ender.twistedremix.TwistedUtil.Enums;

public class GameScreen implements TwistedScreen {

	private TwistedRemix game;

	int width, height;

	public Stage stage;

	public Skin skin;

	private OrthographicCamera mainCamera;

	BoardPanel boardPanel;

	public GameScreen(final TwistedRemix game) {
		this.game = game;

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		boardPanel = new BoardPanel(Enums.BoardLayout.CLASSIC);
		boardPanel.setPosition(1000, 500);
		stage.addActor(boardPanel);

		mainCamera = new OrthographicCamera();
		mainCamera.setToOrtho(false, stage.getWidth(), stage.getHeight());
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);

		stage.getBatch().begin();

		stage.getBatch().end();

		stage.draw();
	}

	@Override
	public void show() {

	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {

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
