package com.example.expandablelistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.HeterogeneousExpandableList
import androidx.core.os.bundleOf
import com.example.expandablelistview.adapter.ExpandableAdapter
import com.example.expandablelistview.util.ObjectList

class MainActivity : AppCompatActivity() {
    private lateinit var expandableListView: ExpandableListView
    private lateinit var expandableAdapter: ExpandableAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expandableListView = findViewById(R.id.expandListView)

        ObjectList.title.add("Football Clubs")
        ObjectList.title.add("Programming languages")

        ObjectList.subtitle.add(ObjectList.footballerList())
        ObjectList.subtitle.add(ObjectList.languages())

        expandableAdapter = ExpandableAdapter(this,ObjectList.title, ObjectList.subtitle)
        expandableListView.setAdapter(expandableAdapter)

        expandableAdapter.onClick = {
            val bundle = bundleOf("text" to it)
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
























