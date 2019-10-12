@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import kotlinx.html.InputType
import lesson1.task1.discriminant
import lesson1.task1.sqr
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var result = 0.0
    var a = 0.0
    for (element in v) {
        a = element * element
        result += a
    }
    return sqrt(result)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    return if (list.isEmpty()) 0.0
    else list.average()
}
//    var sum = 0.0
//    for (element in list) sum += element
//    return if (list.isEmpty()) 0.0
//    else sum / list.size
//}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val sr = mean(list)
    for (i in 0 until list.size) {
        list[i] -= sr
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var result = 0
    for (i in 0 until a.size)
        result += a[i] * b[i]
    return result
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    var result = 0
    var y = 1
    if (p.isEmpty()) return 0
    if (p.size == 1) return p.first()
    for (i in 1 until p.size) {
        y *= x
        result += p[i] * y
    }
    return result + p.first()
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    var result = 0
    for (i in 0 until list.size) {
        result += list[i]
        list[i] = result
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var number = n
    var result = mutableListOf<Int>()
    for (i in 2..n) {
        while (number % i == 0) {
            result.add(i)
            number /= i
        }
    }
    return result.sorted()
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var number = n
    var result = 0
    val a = mutableListOf<Int>()
    if (number == 0) {
        a.add(0)
        return a
    }
    while (number > 0) {
        result = number % base
        a.add(result)
        number /= base
    }
    a.reverse()
    return a
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String {
    var result = ""
    for (element in convert(n, base)) {
        if (element < 10) result += element
        else result += 'a' + (element - 10)
    }
    return result
}


/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var number = 0
    for ((x, element) in digits.reversed().withIndex()) {
        number += (element * (base.toDouble()).pow(x)).toInt()
    }
    return number
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int {
    var list = mutableListOf<Int>()
    for (element in str) {
        if (element.toInt() > 96) list.add(element.toInt() - 87)
        else list.add(element.toInt() - 48)
    }
    return decimal(list.toList(), base)
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val numbers = listOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)
    val rom = listOf("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
    val new = numbers.zip(rom).toMap()
    var result = ""
    var x = n
    for (element in numbers.reversed()) {
        while (x > 0) {
            if (x / element >= 1) {
                result += new[element]
                x -= element
            } else break
        }
    }
    return result
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var number = n
    var result = ""
    val units = listOf(
        "",
        " один",
        " два",
        " три",
        " четыре",
        " пять",
        " шесть",
        " семь",
        " восемь",
        " девять"
    )
    val unitsTH = listOf(
        " тысяч",
        " одна",
        " две",
        " три",
        " четыре",
        " пять",
        " шесть",
        " семь",
        " восемь",
        " девять"
    )
    val ten = listOf(
        "",
        " одиннацать",
        " двенадцать",
        " тринадцать",
        " четырнадцать",
        " пятнадцать",
        " шестнадцать",
        " семнадцать",
        " восемнадцать",
        " девятнадцать"
    )
    val decades = listOf(
        "",
        "",
        " двадцать",
        " тридцать",
        " сорок",
        " пятьдесят",
        " шестьдесят",
        " семьдесят",
        " восемьдесят",
        " девяносто"
    )
    val hundreds = listOf(
        "",
        " сто",
        " двести",
        " триста",
        " четыреста",
        " пятьсот",
        " шестьсот",
        " семьсот",
        " восемьсот",
        " девятьсот"
    )
    if (number / 1000 >= 1) {
        if (number / 100000 > 0) {
            result += hundreds[number / 100000]
            number %= 100000
        }
        if (number / 1000 > 20) {
            result += decades[number / 10000]
            number %= 10000
        }
        if (number in 11000..19999) {
            number %= 10000
            result += ten[number / 1000] + " тысяч"
            number %= 1000
        }
        if (n > 999) {
            if ((n % 10000) / 1000 == 0) result += unitsTH[0]
            if (number / 1000 == 1) result += unitsTH[1] + " тысяча"
            if (number / 1000 in 2..4) result += unitsTH[number / 1000] + " тысячи"
            if (number / 1000 in 5..9) result += unitsTH[number / 1000] + " тысяч"
            number %= 1000
        }
    }
    if (number / 100 > 0) {
        result += hundreds[number / 100]
        number %= 100
    }
    if (number > 19) {
        result += decades[number / 10]
        number %= 10
    }
    if (number in 11..19) result += ten[number % 10]
    if (number < 10) result += units[number]
    return result.trim()
}
