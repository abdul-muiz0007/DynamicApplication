package com.example.dynamicapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import com.example.dynamicapplication.ConfigurationModel
import com.example.dynamicapplication.databinding.FragmentCustomBinding


class CustomFragment : Fragment() {

    private val binding by lazy { FragmentCustomBinding.inflate(layoutInflater) }
    private val pageNo by lazy { arguments?.getInt("pageNo") }
    private val pageDetails by lazy { arguments?.getSerializable("pageDetails") as ConfigurationModel.PageModel }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addObservers {
            initUi()
            attachListeners()
        }

    }

    private fun addObservers(callback: () -> Unit) {
        callback()
    }

    private fun initUi() {

        pageDetails.elements.forEach {
            when (it.type) {
                "button" -> {
                    val button = Button(requireContext())
                    button.text = it.label
                    binding.root.addView(button)
                }
                "image" -> {
                    val imageView = ImageView(requireContext())
                    val lp = LinearLayout.LayoutParams(200, 200)
                    imageView.layoutParams = lp
                    imageView.contentDescription = it.alt
                    imageView.load(it.url)
                    binding.root.addView(imageView)
                }
                "text" -> {
                    val textView = TextView(requireContext())
                    textView.text = it.content
                    binding.root.addView(textView)
                }
            }
        }

    }

    private fun attachListeners() {

    }

}