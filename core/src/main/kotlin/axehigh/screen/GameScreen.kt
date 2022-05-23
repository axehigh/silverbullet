package axehigh.screen

import axehigh.SilverBullet
import axehigh.UNIT_SCALE
import axehigh.ecs.component.*
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.MathUtils
import ktx.ashley.entity
import ktx.ashley.with
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<GameScreen>()

class GameScreen(game: SilverBullet, batch: Batch) : DarkMatterScreen(game, batch) {

    override fun show() {
        LOG.debug { "First Screen" }
//        repeat(10) {
            engine.entity{
                with<TransformComponent>{
                    position.set(MathUtils.random(0f,9f),MathUtils.random(0f,16f),0f)
                }

                with<GraphicComponent>()
                with<PlayerComponent>()
                with<FacingComponent>()
            }
//        }
    }

    override fun render(delta: Float) {
        engine.update(delta)
    }


    override fun dispose() {
    }

}
