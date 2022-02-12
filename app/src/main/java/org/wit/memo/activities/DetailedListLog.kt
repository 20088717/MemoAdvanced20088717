package org.wit.memo.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_memo_list.*
import org.jetbrains.anko.intentFor
import org.wit.memo.R
import org.wit.memo.main.MainApp
import org.wit.memo.models.MemoModel

class DetailedListLog : AppCompatActivity(), LogListener{
    lateinit var app: MainApp
    var memo = MemoModel()
    private var matchedPatient: ArrayList<MemoModel> = arrayListOf()
    private var thePatients = mutableListOf<MemoModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_log_list)
         app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager   //recyclerView is a widget in activity_memo_list.xml
        loadMemos()
        performSearch()

        toolbar.title = title
        setSupportActionBar(toolbar)


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_detailed_log, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.

                R.id.action_home -> {
                    startActivity(Intent(this, MemoListActivity::class.java))
                    true
                }

//            R . id . action_search -> {
//
//                startActivityForResult(intentFor<DetailedLog>().putExtra("Search Log", memo), 0)
//
//                true
//            }
//            else -> super.onOptionsItemSelected(item)

        }
        return super.onOptionsItemSelected(item)
    }

     override fun onMemoClick(memo: MemoModel) {
        startActivityForResult(intentFor<MemoActivity>().putExtra("memo_edit", memo), 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loadMemos()
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun loadMemos() {
        showMemos(app.memos.findAll())
    }

    fun showMemos (memos: List<MemoModel>) {
        recyclerView.adapter = LogAdapter(memos, this)
        recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun search(text: String?) {
        matchedPatient = arrayListOf()

        text?.let {
            thePatients.forEach { patient ->
                if (patient.type.contains(text, true)
                ) {
                    matchedPatient.add(patient)
                }
            }
            showMemos(matchedPatient)
            if (matchedPatient.isEmpty()) {
                Toast.makeText(this, "No match found!", Toast.LENGTH_SHORT).show()
            }

            thePatients= app.memos.findAll() as MutableList<MemoModel>
        }
    }

    private fun performSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText)
                return true
            }
        })
    }


}