package axehigh.ecs.component

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor

class GraphicComponent : Component, Pool.Poolable {
    var sprite:Sprite = Sprite()

    override fun reset() {
        sprite.texture = null
        sprite.setColor(1f,1f,1f,1f)
    }

    // companion is static
    // can cause problems on android, static is removed first by GC.
    companion object{
        val mapper: ComponentMapper<GraphicComponent> = mapperFor<GraphicComponent>()
    }
}
