package com.sourcebits.people.bottomnavigationsample

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_live.*

/**
 * A simple [Fragment] subclass.
 */
class TurnTableFragmentOne : Fragment() {

    var text: String = ""
    lateinit var navigation: Navigation

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            // Inflate the layout for this fragment
            inflater.inflate(R.layout.fragment_live, container, false)

    companion object {
        fun newInstance(text1: String): TurnTableFragmentOne =
                TurnTableFragmentOne().apply {
                    text = text1
                }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        defineClick()
        setTextView(text)
    }

    fun setTextView(pageName: String) {
        tv_page_name?.text = pageName
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (parentFragment != null && parentFragment is Navigation) {
            navigation = (parentFragment as Navigation?)!!
        }
    }

    fun defineClick() {
        tv_page_name.setOnClickListener(View.OnClickListener {
            navigation.addNewFragment(TurnTableFragmentTwo.newInstance("Turn Two"))
        })
    }
}