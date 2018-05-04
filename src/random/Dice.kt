package random

import geometry.Angle
import geometry.Vector2D
import java.util.*

class Dice(seed: Long? = null) {

    private val rng: Random = if(seed != null) Random(seed) else Random()


    fun randInt(range: IntRange): Int =
            range.first + rng.nextInt(range.last - range.first + 1)


    fun randDouble(min: Double = 0.0, max: Double = 1.0): Double =
            min + rng.nextDouble() * (max - min)


    fun flipCoin(): Boolean =
            rng.nextBoolean()


    fun randAngle(): Angle =
            Angle(randDouble(max = Const.TAU))


    fun randVect2D(minMagnitude: Double = 0.0, maxMagnitude: Double = 1.0): Vector2D =
            Vector2D(randAngle(), randDouble(minMagnitude, maxMagnitude))

}