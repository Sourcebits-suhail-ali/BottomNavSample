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
 //               when(position){
//
//                    0-> return fragment
//                    1-> return FeaturedFragment.newInstance("Featured")
//                    2-> return ShopFragment.newInstance("Shop")
//                    3-> return LoveFragment.newInstance("Love")
//                    4-> return BagFragment.newInstance("Bag")
 //               }
 //              return LiveFragment.newInstance("Default")

            }

        }

        if (savedInstanceState == null) {
            fragmentStateManager.changeFragment(0)
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener( mOnNavigationItemSelectedListener )
        bottomNavigation.setOnNavigationItemReselectedListener(mOnNavigationReselectionListener)


    }

    public fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    public fun openFragmentAddToStack(fragment: Fragment, tag: String){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(tag)
        transaction.commit()
    }

    fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
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




   /* private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.navigation_live ->{
                toolbar.title = getString(R.string.navigation_live)
                val liveFragment = LiveFragment.newInstance(toolbar.title.toString())
                openFragment(liveFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_featured->{
                toolbar.title = getString(R.string.navigation_featured)
                val liveFragment = FeaturedFragment.newInstance(toolbar.title.toString())
                openFragment(liveFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shop ->{
                toolbar.title = getString(R.string.navigation_shop)
                val liveFragment = ShopFragment.newInstance(toolbar.title.toString())
                openFragment(liveFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_love ->{
                toolbar.title = getString(R.string.navigation_love)
                val liveFragment = LoveFragment.newInstance(toolbar.title.toString())
                openFragment(liveFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_bag ->{
                toolbar.title = getString(R.string.navigation_bag)
                val liveFragment = BagFragment.newInstance(toolbar.title.toString())
                openFragment(liveFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    private val mOnNavigationReselectionListener = BottomNavigationView.OnNavigationItemReselectedListener{ item ->

        when(item.itemId) {
            R.id.navigation_live ->{
                toolbar.title = getString(R.string.navigation_live)
//                val liveFragment = LiveFragment.newInstance(toolbar.title.toString())
//                openFragment(liveFragment)
                showToast(toolbar.title.toString() +  " reselected")
                return@OnNavigationItemReselectedListener
            }
            R.id.navigation_featured->{
                toolbar.title = getString(R.string.navigation_featured)
//                val liveFragment = FeaturedFragment.newInstance(toolbar.title.toString())
//                openFragment(liveFragment)
                showToast(toolbar.title.toString() +  " reselected")
                return@OnNavigationItemReselectedListener
            }
            R.id.navigation_shop ->{
                toolbar.title = getString(R.string.navigation_shop)
//                val liveFragment = ShopFragment.newInstance(toolbar.title.toString())
//                openFragment(liveFragment)
                showToast(toolbar.title.toString() +  " reselected")
                return@OnNavigationItemReselectedListener
            }
            R.id.navigation_love ->{
                toolbar.title = getString(R.string.navigation_love)
//                val liveFragment = LoveFragment.newInstance(toolbar.title.toString())
//                openFragment(liveFragment)
                showToast(toolbar.title.toString() +  " reselected")
                return@OnNavigationItemReselectedListener
            }
            R.id.navigation_bag ->{
                toolbar.title = getString(R.string.navigation_bag)
//                val liveFragment = BagFragment.newInstance(toolbar.title.toString())
//                openFragment(liveFragment)
                showToast(toolbar.title.toString() +  " reselected")
                return@OnNavigationItemReselectedListener
            }
        }
    }*/

}
