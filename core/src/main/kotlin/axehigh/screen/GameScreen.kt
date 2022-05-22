package axehigh.screen

import axehigh.SilverBullet
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.graphics.use
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<GameScreen>()

class GameScreen(game: SilverBullet, batch: Batch) : AbstractScreen(game, batch) {

    private val texture = Texture(Gdx.files.internal("ship_base.png"))
    private val sprite = Sprite(texture)

    override fun show() {
        LOG.debug { "First Screen" }
        sprite.setPosition(100f,100f)
    }

    override fun render(delta: Float) {

        batch.use {
            sprite.draw(it)
        }
//        batch.begin()
//
//        sprite.draw(batch)
//
//        batch.end()

    }

    override fun dispose() {
        texture.dispose();
    }

}
