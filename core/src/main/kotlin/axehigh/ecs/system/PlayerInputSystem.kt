package axehigh.ecs.system

import axehigh.ecs.component.FacingComponent
import axehigh.ecs.component.FacingDirection
import axehigh.ecs.component.PlayerComponent
import axehigh.ecs.component.TransformComponent
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.Viewport
import ktx.ashley.allOf
import ktx.ashley.get

private const val TOUCH_TOLERANCE_DISTANCE = 0.2F

class PlayerInputSystem(
    private val gameViewPort: Viewport
) : IteratingSystem(allOf(PlayerComponent::class, TransformComponent::class, FacingComponent::class).get()) {

    private val tmpVec = Vector2()

    override fun processEntity(entity: Entity, deltaTime: Float) {

        val facing: FacingComponent? = entity[FacingComponent.mapper]
        require(facing != null) { "Entity|entity must have a FacingComponent. entity = $entity" }

        val transform: TransformComponent? = entity[TransformComponent.mapper]
        require(transform != null) { "Entity|entity must have a FacingComponent. entity = $entity" }

        tmpVec.x = Gdx.input.x.toFloat()
        tmpVec.y = Gdx.input.y.toFloat()

        gameViewPort.unproject(tmpVec)

        val diffX = tmpVec.x - transform.position.x - transform.size.x * 0.5f
        facing.direction = when {
            diffX < -TOUCH_TOLERANCE_DISTANCE -> FacingDirection.LEFT
            diffX > TOUCH_TOLERANCE_DISTANCE -> FacingDirection.RIGHT
            else -> FacingDirection.DEFAULT
        }
    }


}
