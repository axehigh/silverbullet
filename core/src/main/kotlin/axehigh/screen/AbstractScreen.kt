package axehigh.screen

import axehigh.SilverBullet
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxScreen

abstract class AbstractScreen(
    val game: SilverBullet,
    val batch: Batch = game.batch
) : KtxScreen {
}
