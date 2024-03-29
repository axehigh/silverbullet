package axehigh.ecs.component

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor

class TransformComponent : Component, Pool.Poolable, Comparable<TransformComponent> {

    val position = Vector3()
    val prevPosition = Vector3()
    val interPolationPosition = Vector3()
    val size = Vector2(1f, 1f)
    var rotationDeg = 0f

    override fun reset() {
        position.set(Vector3.Zero)
        size.set(Vector2(1f, 1f))
        rotationDeg = 0f
    }

    fun setInitialPosition(x:Float, y:Float, z:Float) {
        position.set(x, y, z)
        prevPosition.set(x, y, z)
        interPolationPosition.set(x, y, z)

    }

    override fun compareTo(other: TransformComponent): Int {
        val zDiff: Float = position.z - other.position.z
        return (if (zDiff == 0f) position.y - other.position.y else zDiff).toInt()
    }

    // companion is static
    // can cause problems on android, static is removed first by GC.
    companion object {
        val mapper: ComponentMapper<TransformComponent> = mapperFor<TransformComponent>()
    }

}
