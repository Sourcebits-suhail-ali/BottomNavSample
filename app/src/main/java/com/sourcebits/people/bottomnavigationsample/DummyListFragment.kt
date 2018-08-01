package com.sourcebits.people.bottomnavigationsample

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_dummy_list.*

/**
 * A simple [Fragment] subclass.
 */
class DummyListFragment : Fragment() {

    var text: String = ""
    lateinit var navigation: Navigation
    val animals: ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            // Inflate the layout for this fragment
            inflater.inflate(R.layout.fragment_dummy_list, container, false)

    companion object {
        fun newInstance(text1: String): DummyListFragment =
                DummyListFragment().apply {
                    text = text1
                }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        defineRecylerView()
        setTextView(text)
    }

    fun setTextView(pageName: String) {
        //tv_page_name?.text = pageName
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (parentFragment != null && parentFragment is Navigation) {
            navigation = (parentFragment as Navigation?)!!
        }
    }

    fun defineRecylerView() {
        addAnimals()
        // Creates a vertical Layout Manager
        rv.layoutManager = LinearLayoutManager(activity)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        rv.adapter = AnimalAdapter(animals,activity)

    }


    fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }
}