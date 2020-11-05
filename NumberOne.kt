fun main() {
    val text = readLine()!!.toString()
    print(isPalindrome(text))
}

fun isPalindrome(text: String): Boolean = removeSymbols(text).equals(removeSymbols(text).toCharArray().reversed().joinToString(""), ignoreCase = true)

fun removeSymbols(text: String): String = text.toCharArray().filter { it.isLetterOrDigit() }.joinToString("")



