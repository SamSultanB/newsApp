package sam.sultan.newsapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import sam.sultan.newsapp.adapters.RvAdapter
import sam.sultan.newsapp.databinding.ActivityMainBinding
import sam.sultan.newsapp.databinding.FragmentMainPageBinding
import sam.sultan.newsapp.models.entities.Article
import sam.sultan.newsapp.models.viewModels.NewsViewModel


class MainPageFragment : Fragment() {

    lateinit var binding: FragmentMainPageBinding
    var adapter = RvAdapter()
    val viewModel = NewsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        var test = listOf<Article>(Article(1, "author", "contentContnent", "fjsafjsfs", "3434", "jfsj",  "fd", "lflf", 1),
//            Article(1, "author", "contentContnent", "fjsafjsfs", "3434", "jfsj",  "fd", "lflf", 1))

        viewModel.news.observe(viewLifecycleOwner, Observer {
            adapter.setNewsList(it.articles)
        })
        binding.mainRv.layoutManager = LinearLayoutManager(requireContext())
        binding.mainRv.adapter = adapter
    }
}