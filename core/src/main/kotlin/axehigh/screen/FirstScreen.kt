package axehigh.screen

import axehigh.SilverBullet
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import ktx.app.KtxScreen
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<FirstScreen>()

class FirstScreen(game: SilverBullet) : AbstractScreen(game) {

    override fun show() {
        LOG.debug { "First Screen" }
    }

    override fun render(delta: Float) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            game.setScreen<SecondScreen>()
        }
    }

}