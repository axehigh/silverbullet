package axehigh.ecs.component

import axehigh.UNIT_SCALE
import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor
class GraphicComponent : Component, Pool.Poolable {
    var sprite:Sprite = Sprite()

    override fun reset() {
        sprite.texture = null
        sprite.setColor(1f,1f,1f,1f)
    }

    fun setSpriteRegion(region: TextureRegion) {
        sprite.run {
            setRegion(region)
            setSize(texture.width * UNIT_SCALE, texture.height * UNIT_SCALE)
            setOriginCenter()
        }
    }

    // companion is static
    // can cause problems on android, static is removed first by GC.
    companion object{
        val mapper: ComponentMapper<GraphicComponent> = mapperFor<GraphicComponent>()
    }
}

