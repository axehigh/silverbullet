package axehigh.screen

import axehigh.SilverBullet
import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.app.KtxScreen

abstract class DarkMatterScreen(
    val game: SilverBullet,
    val batch: Batch = game.batch,
    val gameViewPort: FitViewport = game.gameViewPort,
    val engine: Engine = game.engine
) : KtxScreen {

    override fun resize(width: Int, height: Int) {
        gameViewPort.update(width, height, true)
    }

}
