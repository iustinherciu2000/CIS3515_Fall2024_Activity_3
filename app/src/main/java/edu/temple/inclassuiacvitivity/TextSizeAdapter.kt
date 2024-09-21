package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextSizeAdapter(private val context: Context, private val numbers: Array<Int>) : BaseAdapter() {
    override fun getCount(): Int {
        return numbers.size     // returns the number of items in the numbers array.
    }

    override fun getItem(position: Int): Any {
        return numbers[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView: TextView

        if (convertView == null) {
            textView = TextView(context)
            textView.textSize = 22F
        } else {
            textView = convertView as TextView
        }

        textView.text = numbers[position].toString()
        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?) =
        getView(position, convertView, parent).apply {
        return super.getDropDownView(position, convertView, parent)
            (this as TextView).textSize = numbers[position].toFloat()
    }
}
