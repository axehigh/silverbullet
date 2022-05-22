package axehigh

import axehigh.screen.FirstScreen
import axehigh.screen.SecondScreen
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<SilverBullet>()

class SilverBullet : KtxGame<KtxScreen>() {
    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "Silverbullet starts" }
        addScreen(FirstScreen(this))
        addScreen(SecondScreen(this))
        setScreen<FirstScreen>()
    }

}



