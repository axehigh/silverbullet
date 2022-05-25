package axehigh

import axehigh.ecs.system.PlayerAnimationSystem
import axehigh.ecs.system.PlayerInputSystem
import axehigh.ecs.system.RenderSystems
import axehigh.screen.DarkMatterScreen
import axehigh.screen.GameScreen
import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.app.KtxGame
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<SilverBullet>()
const val UNIT_SCALE: Float = 1 / 16f

class SilverBullet : KtxGame<DarkMatterScreen>() {
    val gameViewPort = FitViewport(9f, 16f)
    val batch: Batch by lazy { SpriteBatch() }

    val graphicsAtlas by lazy { TextureAtlas(Gdx.files.internal("assets.atlas")) }
    val engine: Engine by lazy {
        PooledEngine().apply {
            addSystem(PlayerInputSystem(gameViewPort))
            addSystem(
                PlayerAnimationSystem(
                    graphicsAtlas.findRegion("ship_base"),
                    graphicsAtlas.findRegion("ship_left"),
                    graphicsAtlas.findRegion("ship_right")
                )
            )
            addSystem(RenderSystems(batch, gameViewPort))
        }
    }

    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "Silverbullet starts" }
        addScreen(GameScreen(this, batch))
        setScreen<GameScreen>()
    }

    override fun dispose() {
        super.dispose()
        LOG.debug { "Sprites in batch: ${(batch as SpriteBatch).maxSpritesInBatch}" }
        batch.dispose()

        // will be improved with assetmanager

        graphicsAtlas.dispose()

    }

}



