// ЗДЕСЬ ПРЕДСТАВЛЕНО 2 ВАРИАНТА РЕШЕНИЯ ПОСТАВЛЕННОЙ ЗАДАЧИ РАЗЛИЧНЫМИ МЕТОДАМИ


// 1 вариант
// Создаем хеш-таблицу, которая будет хранить количество каждого элемента массива
// Проходим по всем элементам массива, обновляя количество его вхождений в хеш-таблице
// После заполнения хеш-таблицы значениями, проходим по ней, выводя элемент и количество вхождений
//
fun countElements1(array: Array<Int>) {
    val elementCountMap = HashMap<Int, Int>()
    for (element in array) {
        elementCountMap[element] = elementCountMap.getOrDefault(element, 0) + 1
    }
    for ((key, value) in elementCountMap) {
        println("$key  $value")
    }
}


// 2 вариант
// Группируем все элементы массива по значению 
// Считаем количество каждого значения
// Проходим по каждой записи в словаре и выводим элемент и количество вхождений
//
fun countElements2(array: Array<Int>) {
    array.groupingBy { it }.eachCount().forEach { (key, value) ->
        println("$key  $value")
    }
}


// Пример функции main()
//
fun main() {
    var arr = arrayOf(1, 2, 4, 4, 2, 7 , 4, 2, 4, 7)
    println("1 вариант:")
    countElements1(arr)
    println("2 вариант:")
    countElements2(arr)
}
