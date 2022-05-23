package axehigh.ecs.system

import axehigh.ecs.component.FacingComponent
import axehigh.ecs.component.FacingDirection
import axehigh.ecs.component.GraphicComponent
import axehigh.ecs.component.PlayerComponent
import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.EntityListener
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.g2d.TextureRegion
import ktx.ashley.allOf
import ktx.ashley.get

class PlayerAnimationSystem(
    private val defaultRegion: TextureRegion,
    private val leftRegion: TextureRegion,
    private val rightRegion: TextureRegion,
) : IteratingSystem(
    allOf(
        PlayerComponent::class,
        FacingComponent::class,
        GraphicComponent::class
    ).get()
),
    EntityListener {

    private var lastDirection = FacingDirection.DEFAULT

    override fun addedToEngine(engine: Engine) {
        super.addedToEngine(engine)
        engine.addEntityListener(family, this)
    }

    override fun removedFromEngine(engine: Engine) {
        super.removedFromEngine(engine)
        engine.removeEntityListener(this)
    }


    override fun entityAdded(entity: Entity) {
        entity[GraphicComponent.mapper]?.setSpriteRegion(defaultRegion)
    }

    override fun entityRemoved(entity: Entity?) = Unit

    override fun processEntity(entity: Entity, deltaTime: Float) {

        val facing: FacingComponent? = entity[FacingComponent.mapper]
        require(facing != null) { "Entity|entity must have a FacingComponent. entity = $entity" }

        val graphic: GraphicComponent? = entity[GraphicComponent.mapper]
        require(graphic != null) { "Entity|entity must have a FacingComponent. entity = $entity" }

        if (facing.direction == lastDirection && graphic.sprite.texture != null) {
            // texture already set and direction did not change -> do nothing
        }

        lastDirection = facing.direction
        val region: TextureRegion = when (facing.direction) {
            FacingDirection.LEFT -> leftRegion
            FacingDirection.RIGHT -> rightRegion
            else -> defaultRegion
        }
        graphic.setSpriteRegion(region)

    }
}
