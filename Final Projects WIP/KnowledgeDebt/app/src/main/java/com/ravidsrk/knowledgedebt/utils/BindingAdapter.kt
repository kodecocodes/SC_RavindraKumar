package com.ravidsrk.knowledgedebt.utils

import android.databinding.BindingAdapter
import android.databinding.BindingConversion
import android.support.annotation.ColorInt
import android.support.design.widget.BottomNavigationView
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView

object BindingAdapter {

    @android.databinding.BindingAdapter("onKeyDonePressed")
    fun onKeyDone(editText: EditText, runnable: Runnable) {
        editText.setOnEditorActionListener(TextView.OnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                runnable.run()
                return@OnEditorActionListener true
            }
            false
        })
    }

    /**
     * Underline a portion of the text.
     *
     * @param view The TextView containing the text to underline.
     * @param spanSize an array that contain the start index and the end index.
     */
    @android.databinding.BindingAdapter("underline")
    fun underlineText(view: TextView?, spanSize: IntArray) {
        if (view != null && spanSize.size == 2) {
            val content = SpannableString(view.text)
            content.setSpan(UnderlineSpan(), spanSize[0], spanSize[1], 0)
            view.text = content
        }
    }

    /**
     * Bind an action to an EditText when the "done" key is pressed.
     *
     * @param editText The EditText to listen to.
     * @param action The action to trigger when the "done" key is pressed.
     */
    @android.databinding.BindingAdapter("onKeyDone")
    fun onKeyDone(editText: EditText, action: OnKeyPressedListener) {
        editText.setOnKeyListener { _, keyCode, event ->
            var handled = false
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                action.onKeyPressed()
                handled = true
            }
            handled
        }
    }

    /**
     * Change a ProgressBar color.

     * @param loader the ProgressBar to update.
     * @param color The color value.
     */
    @android.databinding.BindingAdapter("progressColor")
    fun setProgressBarColor(loader: ProgressBar, @ColorInt color: Int) {
        loader.indeterminateDrawable
                .setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN)
    }

    /**
     * Set a listener to a BottomNavigationView when the button are clicked
     *
     * @param view The BottomNavigationView to attach the listener to
     * @param listener A function that take an ItemMenu object as argument and return a boolean.
     * True if an action is take otherwise return false.
     */
    @BindingAdapter("onNavigationItemSelected")
    fun setOnNavigationItemSelected(view: BottomNavigationView, listener: BottomNavigationItemListener) {
        view.setOnNavigationItemSelectedListener { listener.onNavigationItemSelected(it) }
    }

    /* NOTE: those interface are here fot the simple purpose of casting the lambda expression
     set in the xml in order to properly process them
     */
    interface OnKeyPressedListener {
        fun onKeyPressed()
    }

    /**
     * Interface to be implemented in order to use the BottomNavigation binding adapter.
     */
    interface BottomNavigationItemListener {
        fun onNavigationItemSelected(item: MenuItem): Boolean
    }

    /**
     * Bind an action to an EditText when focus is changed
     *
     * @param editText The EditText to listen to.
     * @param handler The action to trigger when the focus is changed.
     */
    @android.databinding.BindingAdapter("onFocusChanged")
    fun onFocusChanged(editText: EditText, handler: KeyboardInputHandler.FocusHandler) {
        editText.setOnFocusChangeListener { _, hasFocus -> handler.onFocusChanged(hasFocus) }
    }

    interface KeyboardInputHandler {

        interface FocusHandler {
            fun onFocusChanged(hasFocus: Boolean)
        }
    }

    @BindingConversion
    fun convertBooleanToVisibility(visible: Boolean): Int = when(visible) {
        true -> View.VISIBLE
        false -> View.GONE
    }
}
