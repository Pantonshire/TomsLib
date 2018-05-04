package geometry

class Vector2D(var x: Double = 0.0, var y: Double = 0.0) {

    constructor(angle: Angle, magnitude: Double = 1.0):
            this(magnitude * angle.cos(), magnitude * angle.sin())


    fun set(newX: Double = 0.0, newY: Double = 0.0): Vector2D {
        x = newX
        y = newX
        return this
    }


    fun set(angle: Angle, magnitude: Double = 1.0): Vector2D {
        x = magnitude * angle.cos()
        y = magnitude * angle.sin()
        return this
    }


    fun magnitude(): Double =
            Math.sqrt(x * x + y * y)


    fun angle(): Angle =
            Angle(Math.atan2(y, x))


    fun floored(): Vector2D =
            Vector2D(Math.floor(x), Math.floor(y))


    fun floor(): Vector2D {
        x = Math.floor(x)
        y = Math.floor(y)
        return this
    }


    fun rounded(): Vector2D =
            Vector2D(Math.round(x).toDouble(), Math.round(y).toDouble())


    fun round(): Vector2D {
        x = Math.round(x).toDouble()
        y = Math.round(y).toDouble()
        return this
    }


    infix fun dotP(other: Vector2D): Double =
            x * other.x + y * other.y


    fun angleBetween(other: Vector2D): Angle =
            Angle(Math.acos((this dotP other) / (magnitude() * other.magnitude())))


    operator fun plus(other: Vector2D): Vector2D =
            Vector2D(x + other.x, y + other.y)


    operator fun minus(other: Vector2D): Vector2D =
            Vector2D(x - other.x, y - other.y)


    operator fun times(scale: Double): Vector2D =
            Vector2D(x * scale, y * scale)


    operator fun div(denominator: Double): Vector2D =
            Vector2D(x / denominator, y / denominator)


    operator fun plusAssign(other: Vector2D) {
        x += other.x
        y += other.y
    }


    operator fun minusAssign(other: Vector2D) {
        x -= other.x
        y -= other.y
    }


    operator fun timesAssign(scale: Double) {
        x *= scale
        y *= scale
    }


    operator fun divAssign(denominator: Double) {
        x /= denominator
        y /= denominator
    }

}