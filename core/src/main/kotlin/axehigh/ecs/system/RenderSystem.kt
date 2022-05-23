package axehigh.ecs.system

import axehigh.ecs.component.GraphicComponent
import axehigh.ecs.component.TransformComponent
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.SortedIteratingSystem
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.utils.viewport.Viewport
import ktx.ashley.allOf
import ktx.ashley.get
import ktx.graphics.use
import ktx.log.Logger
import ktx.log.logger

private val LOG: Logger = logger<RenderSystems>()

class RenderSystems(
    private val batch: Batch,
    private val gameViewPort: Viewport
) : SortedIteratingSystem(
    allOf(TransformComponent::class, GraphicComponent::class).get(),
    compareBy { entity -> entity[TransformComponent.mapper] }
) {


    override fun update(deltaTime: Float) {
        forceSort()
        gameViewPort.apply()
        batch.use(
            gameViewPort.camera.combined
        ) {
            super.update(deltaTime)
        }
    }

    override fun processEntity(entity: Entity, deltaTime: Float) {

        val transform = entity[TransformComponent.mapper]
        require(transform != null) { "Entity must have a transform component. entity = $entity" }

        val graphic: GraphicComponent? = entity[GraphicComponent.mapper]
        require(graphic != null) { "Entity |entity must have a Graphiccomponent. entity = $entity" }

        if (graphic.sprite.texture == null) {
            LOG.error { "Entity has no texture for rendering. entity = $entity" }
            // Could keep going
            return
            // could
            //throw GdxRuntimeException("")
        }

        graphic.sprite.run {
            rotation = transform.rotationDeg
            setBounds(transform.position.x, transform.position.y, transform.size.x, transform.size.y)
            draw(batch)
        }

    }

}
