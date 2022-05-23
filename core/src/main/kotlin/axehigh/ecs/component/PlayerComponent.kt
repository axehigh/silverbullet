package axehigh.ecs.component

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor

const val MAX_LIFE = 100f;
const val MAX_SHIELD = 100f

class PlayerComponent : Component, Pool.Poolable {

    var life: Float = MAX_LIFE
    var maxLife: Float = MAX_LIFE
    var shield = 0f
    var maxShield: Float = MAX_SHIELD
    var distance = 0f


    override fun reset() {
        life = MAX_LIFE
        maxLife = MAX_LIFE
        shield = 0f
        maxShield = MAX_SHIELD
        distance = 0f
    }

    // companion is static
    // can cause problems on android, static is removed first by GC.
    companion object {
        val mapper: ComponentMapper<PlayerComponent> = mapperFor<PlayerComponent>()
    }
}
