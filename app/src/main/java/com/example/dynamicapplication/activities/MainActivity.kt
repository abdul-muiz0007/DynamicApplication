package com.example.dynamicapplication.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.dynamicapplication.ConfigurationModel
import com.example.dynamicapplication.JsonData
import com.example.dynamicapplication.R
import com.example.dynamicapplication.databinding.ActivityMainBinding
import com.example.dynamicapplication.fragments.CustomFragment
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    companion object {
        private var currentNavPos = 0
        private const val POS = "POS"
    }

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val posMap by lazy { ArrayList<Int>() }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(POS, currentNavPos)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        savedInstanceState?.let {
            currentNavPos = it.getInt(POS)
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        addObservers {
            initUi()
            attachListeners()
        }

    }

    private fun addObservers(callback: () -> Unit) {
        callback()
    }

    private fun initUi() {

        val gson = Gson()
        val testModel = gson.fromJson(JsonData.jsonData, ConfigurationModel::class.java)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, testModel.menu.map { it.name })
        binding.dashDropdown.setAdapter(arrayAdapter)

        for (i in 0 until testModel.menu.size) {
            posMap.add(i)
        }
        addFragments(testModel.menu.size, testModel)

    }

    private fun attachListeners() {
        binding.dashDropdown.setOnItemClickListener { _, _, position, _ ->
            if (currentNavPos != position) {
                val pos = posMap[position]
                supportFragmentManager.also { fm ->
                    fm.findFragmentByTag("$pos")?.let { frag ->
                        fm.findFragmentByTag("$currentNavPos")?.let { currentFrag ->
                            supportFragmentManager.beginTransaction().show(frag).hide(currentFrag)
                                .commit()
                            currentNavPos = pos
                        }
                    }
                }
            }
            binding.dashContainer.isVisible = true
            binding.dashDropdownLayout.isVisible = false
        }
        binding.dashBack.setOnClickListener {
            binding.dashDropdownLayout.isVisible = true
            binding.dashContainer.isVisible = false
        }
    }

    private fun addFragments(noOfFrags: Int, configurationModel: ConfigurationModel) {
        supportFragmentManager.fragments.forEach {
            supportFragmentManager.beginTransaction().remove(it).commit()
        }
        val frags = Array(noOfFrags) {
            CustomFragment().apply {
                val bundle = Bundle()
                bundle.putInt("pageNo", it+1)
                bundle.putSerializable("pageDetails", configurationModel.pages[it])
                arguments = bundle
            }
        }
        frags.forEachIndexed { i, frag ->
            val trans = supportFragmentManager.beginTransaction()
            trans.add(R.id.dash_container, frag, "$i")
            if (i != currentNavPos)
                trans.hide(frag)
            trans.commit()
        }
    }

}