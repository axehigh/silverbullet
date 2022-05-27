package axehigh.ecs.system

import axehigh.ecs.component.PlayerComponent
import axehigh.ecs.component.TransformComponent
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import ktx.ashley.allOf
import ktx.ashley.get
import ktx.ashley.getSystem
import kotlin.math.max
import kotlin.math.min

private const val WINDOW_UPDATE_REFRESH_RATE = 0.35f

class DebugSystem : IteratingSystem(allOf(PlayerComponent::class).get()) {
    init {
        setProcessing(true)
    }

    override fun processEntity(entity: Entity, deltaTime: Float) {
        val transform = entity[TransformComponent.mapper]
        require(transform != null) { "Entity |entity| must have a TransformComponent. entity=$entity" }

        val player = entity[PlayerComponent.mapper]
        require(player != null) { "Entity |entity| must have a PlayerComponent. entity=$entity" }


        when {
            Gdx.input.isKeyJustPressed(Input.Keys.NUM_1) -> {
                //kill player
                transform.position.y = 1f
                player.life = 1f
                player.shield = 0f
            }

            Gdx.input.isKeyJustPressed(Input.Keys.NUM_2) -> {
                //add shield
                player.shield = min(player.maxShield, player.shield + 25f)
            }
            Gdx.input.isKeyJustPressed(Input.Keys.NUM_3) -> {
                //remove shield
                player.shield = max(0f, player.shield - 25f)
            }
            Gdx.input.isKeyJustPressed(Input.Keys.NUM_4) -> {
                //disable movement
                engine.getSystem<MoveSystem>().setProcessing(false)
            }
            Gdx.input.isKeyJustPressed(Input.Keys.NUM_5) -> {
                //enable movement
                engine.getSystem<MoveSystem>().setProcessing(true)
            }


        }

        Gdx.graphics.setTitle("DM Debug - pos: ${transform.position},life:${player.life}, shield:${player.shield}")
    }
}
