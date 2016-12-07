package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;

public class GameInput implements InputProcessor {
    public final static int TOUCH_DOWN      = 0x000;
    public final static int TOUCH_UP        = 0x001;
    public final static int TOUCH_DRAGGED   = 0x002;

    private ArrayList<InputEventListener> listeners;

    public GameInput() {
        listeners = new ArrayList<InputEventListener>();
    }

    public void addEventListener(InputEventListener listener) {
        listeners.add(listener);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        for (InputEventListener listener : listeners) {
            listener.notifyEvent(GameInput.TOUCH_DOWN, screenX, screenY, pointer, button);
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (InputEventListener listener : listeners) {
            listener.notifyEvent(GameInput.TOUCH_UP, screenX, screenY, pointer, button);
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        for (InputEventListener listener : listeners) {
            listener.notifyEvent(GameInput.TOUCH_DRAGGED, screenX, screenY, pointer, -1);
        }
        return true;
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
