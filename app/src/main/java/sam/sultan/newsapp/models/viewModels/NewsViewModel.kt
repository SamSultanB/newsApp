package sam.sultan.newsapp.models.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.newsapp.models.entities.News
import sam.sultan.newsapp.models.repositories.NewsRepository

class NewsViewModel: ViewModel() {
    private val repository = NewsRepository()
    val news: MutableLiveData<News> = MutableLiveData()

    init {
        getAllNews()
    }

    fun getAllNews(){
        viewModelScope.launch {
            val response = repository.getAllNews()
            if(response.isSuccessful){
                response.body().let {
                    news.postValue(it)
                }
            }
        }
    }
}