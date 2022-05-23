package axehigh.screen

import axehigh.SilverBullet
import axehigh.UNIT_SCALE
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.graphics.use
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<GameScreen>()

class GameScreen(game: SilverBullet, batch: Batch) : SilverBulletScreen(game, batch) {

    private val viewPort = FitViewport(9f, 16f)
    private val texture = Texture(Gdx.files.internal("ship_base.png"))
    private val sprite = Sprite(texture).apply { setSize(9/16f,10/16f) }

    override fun show() {
        LOG.debug { "First Screen" }
//        sprite.setPosition(9* UNIT_SCALE, 10* UNIT_SCALE)
        sprite.setPosition(1f, 1f)
//        sprite.setScale(0.1f)
    }

    override fun render(delta: Float) {
        viewPort.apply()
        batch.use(viewPort.camera.combined) {
            sprite.draw(it)
        }

        //UI Viewport.apply()

    }

    override fun resize(width: Int, height: Int) {
        viewPort.update(width, height, true)
    }

    override fun dispose() {
        texture.dispose();
    }

}
