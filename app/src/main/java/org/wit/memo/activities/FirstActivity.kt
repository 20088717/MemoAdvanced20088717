package org.wit.memo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_memo.*
import kotlinx.android.synthetic.main.activity_memo.btnAdd
import org.jetbrains.anko.intentFor
import org.wit.memo.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        button_start.setOnClickListener() {
            startActivity(intentFor<MemoListActivity>())
        }
    }
}