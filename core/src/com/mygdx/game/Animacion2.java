package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 * Created by David on 23/9/2016.
 */
public class Animacion2 {
    public int y, x;
    private Animation animation;
    private float tiempo;
    private TextureRegion regionMovimiento[];
    private Texture imagen;
    private TextureRegion frameActual;
    public Animacion2(int y, int x) {

            this.y = y;
            this.x = x;

            imagen=new Texture(Gdx.files.internal("img2.png"));
            TextureRegion temporal[][]=TextureRegion.split(imagen,imagen.getWidth()/3,imagen.getHeight()/4);

            regionMovimiento=new TextureRegion[12];
            int max=0;
            for(int i=0;i<4;i++){
                for(int e=0;e<3;e++){
                    regionMovimiento[max]=temporal[i][e];
                    max++;
                }

            }
            animation=new Animation(1/10f,regionMovimiento);
            tiempo=0f;
        }

        public void render(final SpriteBatch batch) {
            tiempo += Gdx.graphics.getDeltaTime();
            frameActual = animation.getKeyFrame(tiempo, true);
            batch.draw(frameActual, x, y);
        }

    }

