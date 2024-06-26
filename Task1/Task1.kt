import java.util.*
import kotlin.collections.HashSet

// ЗДЕСЬ ПРЕДСТАВЛЕНО 16 ВАРИАНТОВ РЕШЕНИЯ ПОСТАВЛЕННОЙ ЗАДАЧИ РАЗЛИЧНЫМИ МЕТОДАМИ
// В случае отсутствия дублирующихся элементов каждое из решений возвращает 0


// --- 1 ВАРИАНТ ---
// Сортировка и поиск смежных элементов:
// Отсортировать массив и затем пройти по нему, сравнивая соседние элементы.
// Преимущества: Прост в реализации.
// Недостатки: Изменяет исходный массив.
// Pаботает за O(n log n).

fun findDuplicate1(arr: IntArray): Int {
    arr.sort()
    for (i in 1..<arr.size) {
        if (arr[i] == arr[i - 1]) {
            return arr[i]
        }
    }
    return 0 // Если дубликат не найден
}


// --- 2 ВАРИАНТ ---
// Использование хеш-таблицы:
// Использовать хеш-таблицу для отслеживания встреченных элементов.
// Преимущества: Быстрый доступ к элементам.
// Недостатки: Требует дополнительной памяти для хранения хеш-таблицы.
// Работает за O(n).

fun findDuplicate2(arr: IntArray): Int {
    val set = HashSet<Int>()
    for (num in arr) {
        if (!set.add(num)) {
            return num
        }
    }
    return 0 // Если дубликат не найден
}


// --- 3 ВАРИАНТ ---
// Подсчет частоты встречаемости:
// Создать массив длины 100 (поскольку элементы от 1 до 100), индексируя по значениям элементов и увеличивая счетчик. Затем найти элемент со счетчиком больше 1.
// Преимущества: Прост в реализации.
// Недостатки: Требует дополнительной памяти для массива частот.
// Работает за O(n).

fun findDuplicate3(arr: IntArray): Int {
    val count = IntArray(101)
    for (num in arr) {
        count[num]++
    }
    for (i in 1..100) {
        if (count[i] > 1) {
            return i
        }
    }
    return 0 // Если дубликат не найден
}


// --- 4 ВАРИАНТ ---
// Математическая сумма и разность:
// Найти сумму всех элементов массива и сумму арифметической прогрессии от 1 до 100. Разница между ними будет дублирующимся элементом.
// Преимущества: Не требует дополнительной памяти.
// Недостатки: Может вызвать переполнение при больших значениях n.
// Работает за O(n)

fun findDuplicate4(arr: IntArray): Int = arr.sum() - 100 * (100 + 1) / 2


// --- 5 ВАРИАНТ ---
// Поиск в цикле:
// Использовать вложенные циклы для сравнения всех пар элементов массива.
// Преимущества: Прост в реализации.
// Недостатки: Медленный для больших массивов.
// Работает за O(n^2)

fun findDuplicate5(arr: IntArray): Int {
    for (i in arr.indices) {
        for (j in i + 1..<arr.size) {
            if (arr[i] == arr[j]) {
                return arr[i]
            }
        }
    }
    return 0 // Если дубликат не найден
}


// --- 6 ВАРИАНТ ---
// Бинарный поиск в отсортированном массиве:
// Применить бинарный поиск к отсортированному массиву.
// Преимущества: Эффективный для отсортированных массивов.
// Недостатки: Требует сортировки массива.
// Работает за O(n log n)

fun findDuplicate6(arr: IntArray): Int {
    arr.sort()
    var low = 1
    var high = arr.size - 1
    while (low < high) {
        val mid = low + (high - low) / 2
        var count = 0
        for (num in arr) {
            if (num <= mid) {
                count++
            }
        }
        if (count > mid) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return if (arr[low - 1] == arr[low]) arr[low] else 0
}


// --- 7 ВАРИАНТ ---
// Использование массива булевых значений:
// Создать массив булевых значений для отметки встреченных элементов.
// Преимущества: Не требует дополнительной памяти.
// Недостатки: Ограничен диапазон значений элементов.
// Работает за O(n).

fun findDuplicate7(arr: IntArray): Int {
    val seen = BooleanArray(101)
    for (num in arr) {
        if (seen[num]) {
            return num
        }
        seen[num] = true
    }
    return 0 // Если дубликат не найден
}


// --- 8 ВАРИАНТ ---
// Цикл с использованием двумерного массива:
// Использовать двумерный массив для отметки встреченных элементов.
// Преимущества: Эффективный для больших массивов.
// Недостатки: Требует дополнительной памяти для двумерного массива.
// Работает за O(n).

fun findDuplicate8(arr: IntArray): Int {
    val seen = Array(2) { BooleanArray(101) }
    for (num in arr) {
        if (seen[num shr 6][num and 63]) {
            return num
        }
        seen[num shr 6][num and 63] = true
    }
    return 0 // Если дубликат не найден
}


// --- 9 ВАРИАНТ ---
// Использование BitSet:
// Использовать BitSet для отслеживания встреченных элементов.
// Преимущества: Эффективное использование памяти.
// Недостатки: Требует дополнительной памяти.
// Работает за O(n).

fun findDuplicate9(arr: IntArray): Int {
    val bitSet = BitSet(101)
    for (num in arr) {
        if (bitSet.get(num)) {
            return num
        }
        bitSet.set(num)
    }
    return 0 // Если дубликат не найден
}


// --- 10 ВАРИАНТ ---
// Использование Set и суммы:
// Найти дубликат, вычитая сумму Set из суммы элементов массива.
// Преимущества: Прост в реализации.
// Недостатки: Требует дополнительной памяти.
// Работает за O(n).

fun findDuplicate10(arr: IntArray): Int {
    val set = HashSet<Int>()
    var sum = 0
    for (num in arr) {
        if (!set.add(num)) {
            return num
        }
        sum += num
    }
    return 0
}


// --- 11 ВАРИАНТ ---
// Использование Set и вычисления разности:
// Вычислить разность между суммой элементов массива и суммой всех чисел от 1 до 100.
// Преимущества: Прост в реализации.
// Недостатки: Требует дополнительной памяти.
// Работает за O(n).

fun findDuplicate11(arr: IntArray): Int {
    val set = HashSet<Int>()
    var sum = 0
    for (num in arr) {
        if (!set.add(num)) {
            return num
        }
        sum += num
    }
    return 0
}


// --- 12 ВАРИАНТ ---
// Использование XOR:
// Применить XOR ко всем элементам массива и числам от 1 до 100.
// Преимущества: Не требует дополнительной памяти.
// Недостатки: Подходит только для поиска одного дублирующегося элемента в массиве.
// Работает за O(n).

fun findDuplicate12(arr: IntArray): Int {
    var result = 0
    // XOR всех чисел от 1 до 100
    for (i in 1..100) {
        result = result xor i
    }
    // XOR всех элементов массива
    for (num in arr) {
        result = result xor num
    }
    // В результате останется только дублирующийся элемент
    return result
}


// --- 13 ВАРИАНТ ---
// Использование Карта:
// Использовать карту для отслеживания встреченных элементов.
// Преимущества: Гибкость в использовании.
// Недостатки: Требует дополнительной памяти.
// Работает за O(n).

fun findDuplicate13(arr: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (num in arr) {
        if (map.containsKey(num)) {
            return num
        }
        map[num] = 1
    }
    return 0 // Если дубликат не найден
}


// --- 14 ВАРИАНТ ---
// Цикл с хранением индексов:
// Хранить индексы элементов и проверять наличие дубликатов при следующем проходе.
// Преимущества: Прост в реализации.
// Недостатки: Требует дополнительной памяти.
// Работает за O(n).

fun findDuplicate14(arr: IntArray): Int {
    val seen = mutableMapOf<Int, Int>()
    for ((index, num) in arr.withIndex()) {
        if (seen.containsValue(num)) {
            return num
        }
        seen[index] = num
    }
    return 0 // Если дубликат не найден
}


// --- 15 ВАРИАНТ ---
// Подсчет с использованием массива:
// Создать дополнительный массив для подсчета встреченных элементов.
// Преимущества: Прост в реализации.
// Недостатки: Требует дополнительной памяти.
// Работает за O(n).

fun findDuplicate15(arr: IntArray): Int {
    val count = IntArray(101)
    for (num in arr) {
        count[num]++
    }
    for ((index, value) in count.withIndex()) {
        if (value > 1) {
            return index
        }
    }
    return 0 // Если дубликат не найден
}


// --- 16 ВАРИАНТ ---
// Стримы и группировка:
// Использовать стримы для группировки элементов и поиска дубликата.
// Преимущества: Компактный код.
// Недостатки: Требует дополнительной памяти для группировки элементов.
// Работает за O(n).

fun findDuplicate16(arr: IntArray): Int = arr.groupBy { it }.values.firstOrNull { it.size > 1 }?.firstOrNull() ?: 0





// Пример функции main()
fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100)
    println("1. Дублирующийся элемент: ${findDuplicate1(arr)}")
    println("2. Дублирующийся элемент: ${findDuplicate2(arr)}")
    println("3. Дублирующийся элемент: ${findDuplicate3(arr)}")
    println("4. Дублирующийся элемент: ${findDuplicate4(arr)}")
    println("5. Дублирующийся элемент: ${findDuplicate5(arr)}")
    println("6. Дублирующийся элемент: ${findDuplicate6(arr)}")
    println("7. Дублирующийся элемент: ${findDuplicate7(arr)}")
    println("8. Дублирующийся элемент: ${findDuplicate8(arr)}")
    println("9. Дублирующийся элемент: ${findDuplicate9(arr)}")
    println("10. Дублирующийся элемент: ${findDuplicate10(arr)}")
    println("11. Дублирующийся элемент: ${findDuplicate11(arr)}")
    println("12. Дублирующийся элемент: ${findDuplicate12(arr)}")
    println("13. Дублирующийся элемент: ${findDuplicate13(arr)}")
    println("14. Дублирующийся элемент: ${findDuplicate14(arr)}")
    println("15. Дублирующийся элемент: ${findDuplicate15(arr)}")
    println("16. Дублирующийся элемент: ${findDuplicate16(arr)}")
}
