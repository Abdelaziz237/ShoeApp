package com.abdelaziz.tread

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.abdelaziz.tread.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Connect the binding & viewModel
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false)

        viewModel.shoeList.observe(viewLifecycleOwner) { list ->
            for (shoe in list) {
                val image = addView()
                with(image){
                    setImageResource(shoe.images[0])
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }

                val card = CardView(activity!!)
                with(card){
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        480
                    )
                    radius = 32F
                    setPadding(0, 16, 0, 4)
                    addView(image)
                }

                val company = addView(shoe.company, shoe.size)
                with(company){
                    setTextAppearance(R.style.company_text)
                    setPadding(0,16,0, 8)
                }

                val name = addView(shoe.name)
                with(name){
                    setTextAppearance(R.style.shoe_header)
                    setPadding(0,0,0, 8)
                }

                val description = addView(shoe.description)
                with(description){
                    setTextAppearance(R.style.description_text)
                    setPadding(0, 0, 0, 16)
                    textSize = 12F
                }

                with(binding.list){
                    addView(card)
                    addView(company)
                    addView(name)
                    addView(description)
                }
            }
        }

        binding.floatingActionButton.setOnClickListener{
            view?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToAddFragment())
        }

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun addView(): ImageView {
        val view = ImageView(activity!!)
        view.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        return view
    }

    private fun addView(text: String, extra: Double? = null): TextView{
        val view = TextView(activity!!)
        view.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        if(extra == null) view.text = text
        else view.text = "$text   Size: $extra"

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        requireView().findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }
}