import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import java.io.File


fun main() {
//    val jsonString: String = File("./src/main/kotlin/three.json").readText(Charsets.UTF_8)
//    print(jsonString)
    val result = getResourceToList("./src/main/kotlin/three.json")
//    println(result.toString())
}


fun getResourceToList(path: String): List<Record>? {
    return Klaxon().parseArray<Record>(File(path))
}

data class Record(
    @Json(name = "order_id")
    val order_id: String,

    @Json(name = "created_at")
    val created_at: String,

    val customer: Customer,
    val items: List<Item>
)


data class Item(
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "qty")
    val qty: Int,

    @Json(name = "price")
    val price: Int
)


data class Customer(
    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String
)