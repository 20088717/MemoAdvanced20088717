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
import org.jetbrains.anko.startActivityForResult
import org.wit.memo.R
import org.wit.memo.databinding.DetailedLogBinding

class DetailedLog: AppCompatActivity(), AnkoLogger {

    private var _binding: DetailedLogBinding? = null
    private val binding get() = _binding!!

    override fun onResume(){
        super.onResume()


    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View{
////        _binding = DetailedLog.inflate(inflater,container,false)
//
////        val therapy = resources.getStringArray(R.array.therapy_assigned)
////        val arrayAdapter = ArrayAdapter(requireContent(),R.layout.dropdown_item,therapy)
////        binding.autoCompleteTextView.setAdapter(arrayAdapter)
////
//        return binding.root
//    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.detailed_log)
        super.onCreate(savedInstanceState)
        createTextAutoComplete()



    }
    fun createTextAutoComplete(){
        val therapy = resources.getStringArray(R.array.therapy_assigned)
        val arrayAdapter = ArrayAdapter(this,R.layout.dropdown_item,therapy)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_detailed_log, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_home -> { startActivity(Intent(this, MemoActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
//        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_detailed_log, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.action_home -> startActivityForResult<MemoActivity>(0)
//        }
//        return super.onOptionsItemSelected(item)
//    }

}