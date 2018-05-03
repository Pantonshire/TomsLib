package geometry

class Angle(private var rad: Double = 0.0) {

    init {
        clamp()
    }


    fun set(new: Double) {
        rad = new
        clamp()
    }


    fun setDegrees(degrees: Double) {
        set(degrees / Const.TO_RAD)
    }


    /** Returns the angle in radians between 0 and tau */
    fun radians(): Double = rad


    /** Returns the angle in radians between -pi and pi */
    fun argandRadians(): Double = if(rad > Const.PI) {
        rad - Const.TAU
    } else {
        rad
    }


    /** Returns the angle in degrees between 0 and 360 */
    fun degrees(): Double = rad * Const.TO_DEG


    fun sin(): Double = Math.sin(rad)


    fun cos(): Double = Math.cos(rad)


    fun tan(): Double = Math.tan(rad)


    fun sec(): Double = 1.0 / cos()


    fun csc(): Double = 1.0 / sin()


    fun cot(): Double = 1.0 / tan()


    private fun clamp(): Angle {
        rad %= Const.TAU
        if(rad < 0) {
            rad += Const.TAU
        }
        return this
    }


    operator fun plus(other: Angle): Angle =
            Angle(rad + other.rad)


    operator fun minus(other: Angle): Angle =
            Angle(rad - other.rad)


    operator fun plusAssign(other: Angle) {
        set(rad + other.rad)
    }


    operator fun minusAssign(other: Angle) {
        set(rad - other.rad)
    }

}