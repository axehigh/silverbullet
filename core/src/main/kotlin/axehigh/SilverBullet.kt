package axehigh

import axehigh.screen.AbstractScreen
import axehigh.screen.GameScreen
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxGame
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<SilverBullet>()

class SilverBullet : KtxGame<AbstractScreen>() {

    val batch: Batch by lazy { SpriteBatch() }

    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "Silverbullet starts" }
        addScreen(GameScreen(this, batch))
        setScreen<GameScreen>()
    }

    override fun dispose() {
        super.dispose()
        batch.dispose()
    }

}



