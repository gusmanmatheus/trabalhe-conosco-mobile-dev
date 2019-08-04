package com.example.picpaytest.feature.primingCard

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.picpaytest.R
import com.example.picpaytest.data.model.User
import com.example.picpaytest.feature.registerCard.RegisterActivity
import kotlinx.android.synthetic.main.activity_priming.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PrimingActivity : AppCompatActivity(),PrimingContract.View {
    override val presenter by inject<PrimingPresenter> { parametersOf(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_priming)
        setToolbar()
        register.setOnClickListener {
            presenter.route()

        }
    }
    override fun recoveryData():User {
        return intent.getSerializableExtra(this.resources.getString(R.string.contactsToPriming)) as User

    }
    override fun nextActivity(user: User) {
        val intent = Intent(this,RegisterActivity::class.java)
        intent.putExtra(this.resources.getString(R.string.primingToRegister),user)
        startActivity(intent)
    }

    fun setToolbar(){
        setSupportActionBar(toolbarPriming)
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
        return super.onOptionsItemSelected(item)
    }
}
