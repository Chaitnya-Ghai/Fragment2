package cg.tutorials.example.fragment2.FragmentAssignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import cg.tutorials.example.fragment2.MainActivity
import cg.tutorials.example.fragment2.R
import cg.tutorials.example.fragment2.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [First_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class First_Fragment : Fragment(), ActivityInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
   private lateinit var mainActivity: MainActivity
   private lateinit var binding : FragmentFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity= activity as MainActivity
        mainActivity.activityInterface=this
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding= FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
//        return inflater.inflate(R.layout.fragment_first_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.passValue.setOnClickListener {
            mainActivity.valueFromFragment(binding.etFragment.text.toString())
        }
        binding.increaseBtn.setOnClickListener {
            mainActivity.changeCounterValue("1",binding.etFragment.text.toString())
        }
        binding.decrementBtn.setOnClickListener {
            mainActivity.changeCounterValue("2",binding.etFragment.text.toString())
        }
        binding.resetBtn.setOnClickListener {
            mainActivity.changeCounterValue("3",binding.etFragment.text.toString())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment First_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            First_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun changeColorToRed() {
        binding.fragmentContainerView1.setBackgroundColor(
            ContextCompat.getColor(requireContext(),R.color.red)
        )
    }

    override fun changeColorToGreen() {
        binding.fragmentContainerView1.setBackgroundColor(
            ContextCompat.getColor(requireContext(),R.color.green)
        )
    }

    override fun changeColorToBlue() {
        binding.fragmentContainerView1.setBackgroundColor(
            ContextCompat.getColor(requireContext(),R.color.blue)
        )
    }

    override fun passValueFromAct(valueAsStr:String) {
        binding.etFragment.setText(valueAsStr)
    }
}