package axehigh.screen

import axehigh.SilverBullet
import axehigh.UNIT_SCALE
import axehigh.ecs.component.*
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import ktx.ashley.entity
import ktx.ashley.with
import ktx.log.Logger
import ktx.log.logger
import kotlin.math.min

private val LOG: Logger = logger<GameScreen>()
private const val MAX_DELTA_TIME  = 1/20f

class GameScreen(game: SilverBullet, batch: Batch) : DarkMatterScreen(game, batch) {

    override fun show() {
        LOG.debug { "First Screen" }
//        repeat(10) {
        engine.entity {
            with<TransformComponent> {
//                    position.set(MathUtils.random(0f,9f),MathUtils.random(0f,16f),0f)
//                position.set(4f, 9f, 0f)
                setInitialPosition(4f,9f,0f)
            }
            with<MoveComponent>()
            with<GraphicComponent>()
            with<PlayerComponent>()
            with<FacingComponent>()
        }
//        }
    }

    override fun render(delta: Float) {
        (game.batch as SpriteBatch).renderCalls = 0
        engine.update(min(MAX_DELTA_TIME,delta))
        LOG.debug { "Rendercalls: ${((game.batch as SpriteBatch)).renderCalls}" }
//        if (Gdx.input.isKeyJustPressed())
    }


    override fun dispose() {
    }

}
