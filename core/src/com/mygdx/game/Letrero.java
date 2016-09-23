package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by David on 23/9/2016.
 */
public class Letrero {


        public int y, x;
        private Animation animation;
        private float tiempo;
        private TextureRegion regionMovimiento[];
        private Texture imagen;
        private TextureRegion frameActual;

        public Letrero(int y, int x) {

            this.y = y;
            this.x = x;

            imagen=new Texture(Gdx.files.internal("GAME_LAND.png"));
            TextureRegion temporal[][]=TextureRegion.split(imagen,imagen.getWidth()/3,imagen.getHeight());

            regionMovimiento=new TextureRegion[3];
            for(int i=0;i<3;i++) regionMovimiento[i] = temporal[0][i];
            animation=new Animation(1/2f,regionMovimiento);
            tiempo=0f;
        }

        public void render(final SpriteBatch batch) {
            tiempo += Gdx.graphics.getDeltaTime();
            frameActual = animation.getKeyFrame(tiempo, true);
            batch.draw(frameActual, x, y);
        }

}

