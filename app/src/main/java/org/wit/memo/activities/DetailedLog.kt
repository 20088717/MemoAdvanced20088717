package org.wit.memo.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.*
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.detailed_log.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult
import org.wit.memo.R
import org.wit.memo.main.MainApp
import org.wit.memo.models.MemoModel

class DetailedLog: AppCompatActivity(), AnkoLogger {

    var memo = MemoModel()
    var edit = false
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_log)

        app = application as MainApp

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.item_cancel -> {
                finish()
            }
            R.id.action_detailed_log -> {

                startActivityForResult(intentFor<DetailedListLog>().putExtra("patient_info", memo), 0)

                true
            }
            R.id.action_home -> { startActivity(Intent(this, MemoListActivity::class.java))
                    true
            }
        }

        return super.onOptionsItemSelected(item)
    }



}