import kotlin.math.*


// Под площадью основания будем понимать проекцию фигуры на плоскость



// Интерфейс Figure определяет общие методы для всех фигур
interface Figure {
    fun calculateVolume(): Double
    fun calculateBaseArea(): Double
}

// Класс Cube (куб)
class Cube(val side: Double) : Figure {
    override fun calculateVolume(): Double {
        return side * side * side
    }

    override fun calculateBaseArea(): Double {
        return side * side
    }
}

// Класс Sphere (сфера)
class Sphere(val radius: Double) : Figure {
    override fun calculateVolume(): Double {
        return (4.0 / 3.0) * PI * radius.pow(3.0)
    }

    override fun calculateBaseArea(): Double {
        return PI * radius * radius
    }
}

// Класс Cylinder (цилиндр)
class Cylinder(val radius: Double, val height: Double) : Figure {
    override fun calculateVolume(): Double {
        return PI * radius * radius * height
    }

    override fun calculateBaseArea(): Double {
        return PI * radius * radius
    }
}

// Класс Cone (конус)
class Cone(val radius: Double, val height: Double) : Figure {
    override fun calculateVolume(): Double {
        return PI * radius * radius * height / 3.0
    }

    override fun calculateBaseArea(): Double {
        return PI * radius * radius
    }
}

// Класс RectangularPrism (прямоугольный параллелепипед)
class RectangularPrism(val length: Double, val width: Double, val height: Double) : Figure {
    override fun calculateVolume(): Double {
        return length * width * height
    }

    override fun calculateBaseArea(): Double {
        return length * width
    }
}

// Класс Pyramid (пирамида)
class Pyramid(val baseArea: Double, val height: Double) : Figure {
    override fun calculateVolume(): Double {
        return baseArea * height / 3.0
    }

    override fun calculateBaseArea(): Double {
        return baseArea
    }
}

// Класс Tetrahedron (тетраэдр)
class Tetrahedron(val side: Double) : Figure {
    override fun calculateVolume(): Double {
        return sqrt(2.0) / 12.0 * side.pow(3.0)
    }

    override fun calculateBaseArea(): Double {
        return sqrt(3.0) * side * side / 4.0
    }
}


fun main() {
    // Создание экземпляров фигур
    val cube = Cube(5.0)
    val sphere = Sphere(3.0)
    val cylinder = Cylinder(2.0, 4.0)
    val cone = Cone(2.0, 4.0)
    val rectangularPrism = RectangularPrism(3.0, 4.0, 5.0)
    val pyramid = Pyramid(10.0, 6.0)
    val tetrahedron = Tetrahedron(4.0)

    // Вывод результатов
    println("Куб: Volume = ${cube.calculateVolume()}, Base Area = ${cube.calculateBaseArea()}")
    println("Сфера: Volume = ${sphere.calculateVolume()}, Base Area = ${sphere.calculateBaseArea()}")
    println("Цилиндр: Volume = ${cylinder.calculateVolume()}, Base Area = ${cylinder.calculateBaseArea()}")
    println("Конус: Volume = ${cone.calculateVolume()}, Base Area = ${cone.calculateBaseArea()}")
    println("Прямоугольный параллелепипед: Volume = ${rectangularPrism.calculateVolume()}, Base Area = ${rectangularPrism.calculateBaseArea()}")
    println("Пирамида: Volume = ${pyramid.calculateVolume()}, Base Area = ${pyramid.calculateBaseArea()}")
    println("Тетраэдр: Volume = ${tetrahedron.calculateVolume()}, Base Area = ${tetrahedron.calculateBaseArea()}")
}
