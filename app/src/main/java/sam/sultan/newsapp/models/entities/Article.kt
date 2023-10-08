package sam.sultan.newsapp.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    var saved: Int = 0
) : Serializable
