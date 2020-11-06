import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import java.io.File

fun main() {
    val result = getResourceToList("./src/main/kotlin/three.json")
    getRecordByName("Ari", result).also { print(getTotalRecord(it, it!!.size)) }
    getCustomerNameFilterByMaxBuy(300000, result).also { print(it) }
}

fun getResourceToList(path: String): List<Record>? {
    return Klaxon().parseArray(File(path))
}
//fun getRecordByMonth(month: Month): List<Record>?{
//
//}

fun getRecordByName(name: String, records: List<Record>?): List<Record>?{
    return records!!.filter { name == it.customer.name}
}

//Recursive function
fun getTotalRecord(records: List<Record>?, index: Int): Int{
    return if (index <= 0) 0 else (getTotalRecord(records, index-1) +
            (records?.get(index - 1)?.items?.sumBy { item -> item.price * item.qty }
        ?: 0 ))
}

//TODO: continue this function
fun getCustomerNameFilterByMaxBuy(max: Int, records: List<Record>?): List<String>{
    return records!!.filter {  it.items.sumBy { item -> item.price * item.qty } < max }.distinctBy { it.customer.name }.map { it.customer.name }
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
