package com.suncere.kotlin.mvp.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.eightbitlab.rxbus.Bus
import com.suncere.kotlin.base.common.AppManager
import com.suncere.kotlin.base.ui.activity.BaseActivity
import com.suncere.kotlin.mvp.R
import com.suncere.kotlin.mvp.ui.fragment.HomeFragment
import com.suncere.kotlin.mvp.ui.fragment.MeFragment
import com.suncere.kotlin.mvp.ui.fragment.TestFragment
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * @author lys
 * @time 2019/12/3 16:44
 * @desc:
 */
class MainActivity2 : BaseActivity(), BottomNavigationBar.OnTabSelectedListener {

    private var lastSelectedPosition: Int = 0

    private var pressTime: Long = 0
    //Fragment栈管理
    private val mStack = Stack<Fragment>()
    //主界面Fragment
    private val mHomeFragment: HomeFragment by lazy { HomeFragment() }
    //商品分类Fragment
    private val mTestFragment: TestFragment by lazy { TestFragment() }
    //购物车Fragment
    private val mCartFragment: HomeFragment by lazy { HomeFragment() }
    //消息Fragment
    private val mMsgFragment: HomeFragment by lazy { HomeFragment() }
    //"我的"Fragment
    private val mMeFragment: MeFragment by lazy {
        MeFragment()
    }

    private lateinit var numberBadgeItem: TextBadgeItem
    private lateinit var shapeBadgeItem: ShapeBadgeItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        initFragment()
        initBageItem()
        initBottomNavigationBar()
        initObserve()
        loadCartSize()
    }

    private fun initBageItem() {
        numberBadgeItem = TextBadgeItem()
                .setBorderWidth(4)
                .setBackgroundColor(Color.RED)
                .setHideOnSelect(false)

        shapeBadgeItem = ShapeBadgeItem()
                .setShape(ShapeBadgeItem.SHAPE_OVAL)
                .setSizeInDp(this, 8, 8)
                .setShapeColor(Color.RED)
                .setGravity(Gravity.TOP or Gravity.END)
                .setHideOnSelect(false)
    }


    /**
     * 初始化BottomNavigationBar
     * */
    private fun initBottomNavigationBar() {
        bottom_navigation_bar.clearAll()
        bottom_navigation_bar.setTabSelectedListener(this)

        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED)
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
        bottom_navigation_bar
                .addItem(BottomNavigationItem(R.mipmap.ic_home_white_24dp, "首页").setActiveColorResource(R.color.blue))
                .addItem(BottomNavigationItem(R.mipmap.ic_book_white_24dp, "分类").setActiveColorResource(R.color.blue))
                .addItem(BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "购物车").setActiveColorResource(R.color.blue).setBadgeItem(numberBadgeItem))
                .addItem(BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "消息").setActiveColorResource(R.color.blue).setBadgeItem(shapeBadgeItem))
                .addItem(BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "我的").setActiveColorResource(R.color.blue))
                .initialise()
        bottom_navigation_bar.selectTab(lastSelectedPosition, true)
    }


    /**
     * 初始化栈管理
     **/
    private fun initFragment() {
//        val manager = supportFragmentManager.beginTransaction()
//        manager.add(R.id.mContainer, mHomeFragment)
//        manager.add(R.id.mContainer, mCategoryFragment)
//        manager.add(R.id.mContainer, mCartFragment)
//        manager.add(R.id.mContainer, mMsgFragment)
//        manager.add(R.id.mContainer, mMeFragment)
//        manager.commit()

//        mStack.add(mHomeFragment)
//        mStack.add(mCategoryFragment)
//        mStack.add(mCartFragment)
//        mStack.add(mMsgFragment)
//        mStack.add(mMeFragment)
    }


    private fun replaceFragment(position: Int) {
        supportFragmentManager.beginTransaction().apply {
            when (position) {
                0 -> {
                    replace(R.id.main_frag_container, mHomeFragment)
                }

                1 -> {
                    replace(R.id.main_frag_container, mTestFragment)
                }

                2 -> {
                    replace(R.id.main_frag_container, mCartFragment)
                }

                3 -> {
                    replace(R.id.main_frag_container, mMsgFragment)
                }

                4 -> {
                    replace(R.id.main_frag_container, mMeFragment)
                }
            }
        }.commitAllowingStateLoss()
    }


    /**
     *
     *  监听购物车数量变化事件
     **/
    private fun initObserve() {
//        Bus.observe<UpdateCartSizeEvent>()
//                .subscribe {
//                    loadCartSize()
//                }.registerInBus(this)
//        Bus.observe<MessageBadgeEvent>()
//                .subscribe {
//                    mBottomNavBar.checkMsgBadge(true)
//                }.registerInBus(this)
    }

    /**
     *  加载购物车数量
     */
    private fun loadCartSize() {
//        if (AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE) == 0) {
//            numberBadgeItem.hide()
//        } else {
        numberBadgeItem.setText("10")
        numberBadgeItem.show()
//        }
    }


    override fun onTabReselected(position: Int) {
    }

    override fun onTabUnselected(position: Int) {
    }

    override fun onTabSelected(position: Int) {
        lastSelectedPosition = position
        replaceFragment(lastSelectedPosition)
    }


    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

    /*
    重写back事件，双击退出
     */
    override fun onBackPressed() {
        if (System.currentTimeMillis() - pressTime > 2000) {
            pressTime = System.currentTimeMillis()
            toast("再按一次退出程序")
        } else {
            AppManager.instance.exitApp(this)
        }
    }


}