import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import java.io.File

fun main() {

    val result = getResource("./src/main/kotlin/four.json")
    filterByName("Berry", result).also { println(it) }
    filterByPriceRange(50, 100, result).also { println(it) }
}

fun getResource(path: String): List<Food>? {
    return Klaxon().parseArray(File(path))
}

fun filterByName(name: String, list: List<Food>?): List<Food>{
    return list!!.filter { it.name.toLowerCase().contains(name.toLowerCase()) }
}

fun filterByPriceRange(min: Int, max: Int, list: List<Food>?): List<Food>{
    return list!!.filter { it.price in min..max }
}

data class Food(
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "price")
    val  price: Int
)