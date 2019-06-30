package vn.com.huong.galleryapplication.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

/**
 * Created by HuongPN on 01/18/2019.
 */
@Entity
data class Items(
    @Id(assignable = true) var id: Long = 0,
    var name: String? = null,
    var image: String? = null,
    var price: Int = 0,
    var description: String? = null,
    var time: Date? = null
)

