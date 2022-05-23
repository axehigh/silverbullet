package axehigh.screen

import axehigh.SilverBullet
import com.badlogic.gdx.graphics.g2d.Batch
import ktx.app.KtxScreen

abstract class SilverBulletScreen(
    val game: SilverBullet,
    val batch: Batch = game.batch
) : KtxScreen {
}
