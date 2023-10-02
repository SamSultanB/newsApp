package sam.sultan.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import sam.sultan.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentManager = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if(fragmentManager is FirstFragment){
            binding.textView.text = "first"
        }else if(fragmentManager is SecondFragment){
            binding.textView.text = "second"
        }else{
            binding.textView.text = "first"
        }

    }
}