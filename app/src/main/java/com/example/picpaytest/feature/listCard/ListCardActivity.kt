package com.example.picpaytest.feature.listCard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import com.example.picpaytest.R

import kotlinx.android.synthetic.main.activity_list_card.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ListCardActivity : AppCompatActivity(),ListCardContract.View {

    override val presenter by inject<ListCardPresenter> { parametersOf(this)  }
    private val adapter by lazy { ListCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_card)
        setToolbar()
        presenter.setList()
    }

    override fun setupList() {
        adapter.data = presenter.listCard
        adapter.onItemClick = {
            presenter.addShared(it)
            onBackPressed()
            finish()
        }
        recyclerCards.setHasFixedSize(true)
        recyclerCards.layoutManager = LinearLayoutManager(this)
        recyclerCards.adapter = adapter
    }

    override fun error() {
        Log.i("errorListCard","error")
    }

    fun setToolbar(){
        toolbarListCard
        setSupportActionBar(toolbarListCard)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = ""
        supportActionBar?.setHomeAsUpIndicator(R.mipmap.ic_comeback)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()) {
            android.R.id.home
            -> {
                onBackPressed()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}



