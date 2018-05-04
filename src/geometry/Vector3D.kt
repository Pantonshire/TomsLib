package geometry

class Vector3D(var x: Double = 0.0, var y: Double = 0.0, var z: Double = 0.0) {


    fun magnitude(): Double =
            Math.sqrt(x * x + y * y + z * z)


    infix fun dotP(other: Vector3D): Double =
            x * other.x + y * other.y + z * other.z


    fun angleBetween(other: Vector3D): Angle =
            Angle(Math.acos((this dotP other) / (magnitude() * other.magnitude())))


    operator fun plus(other: Vector3D): Vector3D =
            Vector3D(x + other.x, y + other.y, z + other.z)


    operator fun minus(other: Vector3D): Vector3D =
            Vector3D(x - other.x, y - other.y, z - other.z)


    operator fun times(scale: Double): Vector3D =
            Vector3D(x * scale, y * scale, z * scale)


    operator fun div(denominator: Double): Vector3D =
            Vector3D(x / denominator, y / denominator, z / denominator)


    operator fun plusAssign(other: Vector3D) {
        x += other.x
        y += other.y
        z += other.z
    }


    operator fun minusAssign(other: Vector3D) {
        x -= other.x
        y -= other.y
        z -= other.z
    }


    operator fun timesAssign(scale: Double) {
        x *= scale
        y *= scale
        z *= scale
    }


    operator fun divAssign(denominator: Double) {
        x /= denominator
        y /= denominator
        z /= denominator
    }

}