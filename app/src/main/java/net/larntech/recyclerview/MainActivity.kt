package net.larntech.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyAdapter.ClickListener {

    private val myModel = listOf(
        MyModel("one","user one desc"),
        MyModel("two","user two desc")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myAdapter = MyAdapter(myModel,this,this);
        myAdapter.setData(myModel);

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        recyclerview.adapter = myAdapter;

    }

    override fun clickedItem(myModel: MyModel) {
        Toast.makeText(this,
        "Clicked Item " + myModel.name,
            Toast.LENGTH_LONG
        ).show()
    }
}