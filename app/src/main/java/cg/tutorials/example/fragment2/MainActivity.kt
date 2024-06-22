package cg.tutorials.example.fragment2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cg.tutorials.example.fragment2.FragmentAssignment.ActivityInterface
import cg.tutorials.example.fragment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityInterface:ActivityInterface
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.redBtn.setOnClickListener {
            activityInterface.changeColorToRed()
        }
        binding.greenBtn.setOnClickListener {
            activityInterface.changeColorToGreen()
        }
        binding.blueBtn.setOnClickListener {
            activityInterface.changeColorToBlue()
        }
        binding.PassBtnFromActivity.setOnClickListener {
            if (binding.PassBtnFromActivity.text.toString()==""){
                binding.etMain.error="Enter value"
            }
            else{
                activityInterface.passValueFromAct(binding.etMain.text.toString())
        }
        }
    }
fun valueFromFragment(fEditText:String){
binding.etMain.setText((fEditText))
}
    fun changeCounterValue(whichBtn:String, value:String){
        if(binding.counterValue.text.toString()=="-"||binding.counterValue.text.toString().isEmpty()){
            binding.counterValue.text=(value)
        }
        else{
            when(whichBtn) {
                "1" -> {
                    if (binding.counterValue.text.toString().isEmpty()){
                        binding.counterValue.text ="1"
                    }else {
                        binding.counterValue.text=(binding.counterValue.text.toString().toInt() + 1).toString()
                    }
                }
                "2" -> {
                    if (binding.counterValue.text.toString().isEmpty()){
                        binding.counterValue.text="-1"
                    }
                    binding.counterValue.text = (binding.counterValue.text.toString().toInt() - 1).toString()
                }
                "3" -> {
                    val temp:String?=null
                    binding.counterValue.text=(temp)
                }
            }
        }

    }
}