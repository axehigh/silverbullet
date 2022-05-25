package axehigh.ecs.component

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.gdx.utils.Pool
import com.badlogic.gdx.utils.Pool.Poolable
import ktx.ashley.mapperFor

class RemoveComponent : Component, Pool.Poolable {
    var delay = 0f;

    override fun reset() {
        delay = 0f;
    }

    companion object {
        val mapper: ComponentMapper<RemoveComponent> = mapperFor<RemoveComponent>()
    }
}
