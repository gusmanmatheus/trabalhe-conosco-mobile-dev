package com.example.picpaytest.feature.registerCard

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import com.example.picpaytest.R
import com.example.picpaytest.base.changeText
import com.example.picpaytest.data.model.CreditCard
import com.example.picpaytest.data.model.Payment
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

    override fun dialogError(message: String) {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(message)
        alertDialog.setMessage(this.resources.getString(R.string.errorStoreCard))
        alertDialog.setPositiveButton("Ok", { dialog,which ->
        })
    }

    override fun nextActivity(card: CreditCard) {

        val user:User = intent.getSerializableExtra(this.resources.getString(R.string.primingToRegister)) as User
        val intent = Intent(this,PaymentActivity::class.java)
        intent.putExtra(this.resources.getString(R.string.userRegisterToPayment),user)
        intent.putExtra(this.resources.getString(R.string.cardRegisterToPayment),card)
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

}
