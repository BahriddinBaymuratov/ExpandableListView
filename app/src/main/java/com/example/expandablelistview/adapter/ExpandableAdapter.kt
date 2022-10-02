package com.example.expandablelistview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.expandablelistview.R
import java.text.ParsePosition

class ExpandableAdapter(
    private val context: Context,
    private val title: MutableList<String>,
    private val subtitle: MutableList<MutableList<String>>
): BaseExpandableListAdapter() {

    lateinit var onClick: (String) -> Unit
    override fun getGroupCount(): Int {
        return title.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return subtitle[p0].size
    }

    override fun getGroup(p0: Int): String {
        return title[p0]
    }

    override fun getChild(p0: Int, p1: Int): String {
        return subtitle[p0][p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p0.toLong()
    }

    override fun hasStableIds(): Boolean = false

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var myConvertView = convertView
        if (myConvertView == null){
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            myConvertView = inflater.inflate(R.layout.title_layout,null)
        }
        val textView: TextView = myConvertView!!.findViewById(R.id.textView)
        textView.text = getGroup(groupPosition)
        return myConvertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastCild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var myConvertView = convertView
        if (myConvertView == null){
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            myConvertView = inflater.inflate(R.layout.subtitle_layout, null)
        }
        val textView: TextView = myConvertView!!.findViewById(R.id.textView)
        val text = getChild(groupPosition, childPosition)
        textView.text = text
        myConvertView.setOnClickListener {
            onClick.invoke(text)
        }
        return myConvertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean = true


}