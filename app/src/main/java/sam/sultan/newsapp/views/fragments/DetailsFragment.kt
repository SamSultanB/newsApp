package sam.sultan.newsapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import sam.sultan.newsapp.databinding.FragmentDetailsBinding
import sam.sultan.newsapp.models.entities.Article

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var article = arguments?.getSerializable("article") as Article
        if(article == null){
            Toast.makeText(requireContext(), "Can't load", Toast.LENGTH_SHORT).show()
        }else{
            binding.webContent.apply {
                webViewClient = WebViewClient()
                loadUrl(article.url!!)
            }
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}