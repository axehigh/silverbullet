package axehigh

import axehigh.screen.SilverBulletScreen
import axehigh.screen.GameScreen
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import jdk.internal.org.jline.utils.Log
import ktx.app.KtxGame
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<SilverBullet>()
const val UNIT_SCALE : Float = 1/16f

class SilverBullet : KtxGame<SilverBulletScreen>() {

    val batch: Batch by lazy { SpriteBatch() }

    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "Silverbullet starts"] }
        addScreen(GameScreen(this, batch))
        setScreen<GameScreen>()
    }

    override fun dispose() {
        super.dispose()
        Log.debug{"Sprites in batch: ${(batch as SpriteBatch).maxSpritesInBatch}"}
        batch.dispose()
    }

}



