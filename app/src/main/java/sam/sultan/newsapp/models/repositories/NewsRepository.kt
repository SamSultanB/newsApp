package sam.sultan.newsapp.models.repositories

import sam.sultan.newsapp.models.api.RetrofitInstance

class NewsRepository {

    suspend fun getAllNews() = RetrofitInstance.api.getAllNews()

}