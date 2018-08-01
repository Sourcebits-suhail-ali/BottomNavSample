package com.sourcebits.people.bottomnavigationsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_live.*

/**
 * A simple [Fragment] subclass.
 */
class ShopFragment : Fragment() {

var text:String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        // Inflate the layout for this fragment
       inflater.inflate(R.layout.fragment_live, container, false)

    companion object {
        fun newInstance(text1: String): ShopFragment =
            ShopFragment().apply {
                text =  text1
            }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setTextView(text)
    }

    fun setTextView(pageName:String){
        tv_page_name?.text = pageName
    }

}