package com.zj.baseui.utils

import android.R
import android.view.View
import androidx.collection.ArrayMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.zj.baseui.CLICK_DURING_TIME

object CommonUIImpl {

    internal fun findSupportFragment(target: View, activity: FragmentActivity): Fragment? {
        val tempViewToSupportFragment = ArrayMap<View, Fragment>()
        findAllSupportFragmentsWithViews(
            activity.supportFragmentManager.fragments, tempViewToSupportFragment
        )
        var result: Fragment? = null
        val activityRoot = activity.findViewById<View>(R.id.content)
        var current = target
        while (current != activityRoot) {
            result = tempViewToSupportFragment.get(current)
            if (result != null) {
                break
            }
            current = if (current.parent is View) {
                current.parent as View
            } else {
                break
            }
        }
        tempViewToSupportFragment.clear()
        return result
    }

    private fun findAllSupportFragmentsWithViews(
        topLevelFragments: Collection<Fragment>?, result: MutableMap<View?, Fragment>) {
        if (topLevelFragments == null) {
            return
        }
        for (fragment in topLevelFragments) {
            // getFragment()s in the support FragmentManager may contain null values, see #1991.
            if (fragment == null || fragment.view == null) {
                continue
            }
            result[fragment.view] = fragment
            findAllSupportFragmentsWithViews(fragment.childFragmentManager.fragments, result)
        }
    }

}

internal abstract class NoDoubleClickListener : View.OnClickListener {
    var clickTime = 0L

    override fun onClick(v: View?) {
        val currentTime = System.currentTimeMillis()
        if ((currentTime - clickTime) > CLICK_DURING_TIME) {
            clickTime = currentTime
            noDoubleClick(v)
        }
    }

    abstract fun noDoubleClick(v: View?)

}