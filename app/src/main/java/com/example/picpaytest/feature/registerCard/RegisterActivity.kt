package com.example.picpaytest.feature.registerCard

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import android.view.View
import com.example.picpaytest.R
import com.example.picpaytest.base.changeText
import com.example.picpaytest.data.model.CreditCard
import com.example.picpaytest.data.model.User
import com.example.picpaytest.feature.payment.PaymentActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    override val presenter by inject<RegisterPresenter> { parametersOf(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setToolbar()
        numberCardEd.changeText {
            buttonOnOf()
        }
        holderNameEd.changeText {
            buttonOnOf()
        }
        expirationDateEd.changeText {
            buttonOnOf()
        }
        cvvCardEd.changeText {
            buttonOnOf()
        }
        RegisterCard.setOnClickListener {
            val user = CreditCard (numberCardEd.text.toString(),
                holderNameEd.text.toString(),
                expirationDateEd.text.toString(),
                cvvCardEd.text.toString())
            presenter.storeCard(user)
        }
    }

    override fun dialogError() {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(this.resources.getString(R.string.error))
        alertDialog.setMessage(this.resources.getString(R.string.errorStoreCard))
        alertDialog.setPositiveButton("Ok", { _, _ ->
        })
        alertDialog.show()
    }

    override fun nextActivity(creditCard: CreditCard) {

        val user:User = intent.getSerializableExtra(this.resources.getString(R.string.primingToRegister)) as User
        val intent = Intent(this,PaymentActivity::class.java)
        intent.putExtra(this.resources.getString(R.string.userRegisterToPayment),user)
        intent.putExtra(this.resources.getString(R.string.cardRegisterToPayment),creditCard)
        startActivity(intent)

    }
    fun allVoid() : Boolean {
        return (expirationDateEd.text!!.isEmpty() || cvvCardEd.text!!.isEmpty() ||
                holderNameEd.text!!.isEmpty() || numberCardEd.text!!.isEmpty())
    }

    fun buttonOnOf(){
        if (!allVoid()){
            RegisterCard.visibility = View.VISIBLE
        }else{
            RegisterCard.visibility = View.INVISIBLE
        }

    }
    fun setToolbar(){
        setSupportActionBar(toolbarRegister)
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
