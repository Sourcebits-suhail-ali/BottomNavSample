package com.sourcebits.people.bottomnavigationsample


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar
    lateinit var fragmentStateManager : FragmentStateManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar!!

        fragmentStateManager = object : FragmentStateManager(container, supportFragmentManager){
            override fun getItem(position: Int): Fragment {
                var fragment = HolderFragment()
                var b = Bundle()
                b.putInt("position", position);
                fragment.arguments = b;
                return fragment
            }

        }

        if (savedInstanceState == null) {
            fragmentStateManager.changeFragment(0)
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener )
        bottomNavigation.setOnNavigationItemReselectedListener(mOnNavigationReselectionListener)


    }

    internal fun getNavPositionFromMenuItem(menuItem: MenuItem): Int {
        when (menuItem.itemId) {
            R.id.navigation_live -> return 0
            R.id.navigation_featured -> return 1
            R.id.navigation_shop -> return 2
            R.id.navigation_love -> return 3
            R.id.navigation_bag -> return 4
            else -> return -1
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val position = getNavPositionFromMenuItem(item)
        if (position != -1) {
            fragmentStateManager.changeFragment(getNavPositionFromMenuItem(item))
            return@OnNavigationItemSelectedListener true
        }
        false
    }

    private val mOnNavigationReselectionListener = BottomNavigationView.OnNavigationItemReselectedListener { item ->
        val position = getNavPositionFromMenuItem(item)
        if (position != -1) {
            fragmentStateManager.removeFragment(position)
            fragmentStateManager.changeFragment(position)
        }
    }

    protected override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        onCreate(savedInstanceState)
    }
}
