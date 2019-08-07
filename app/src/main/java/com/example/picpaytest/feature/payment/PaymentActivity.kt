package com.example.picpaytest.feature.payment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.*
import com.example.picpaytest.R
import com.example.picpaytest.base.changeText
import com.example.picpaytest.base.loadImage
import com.example.picpaytest.data.model.CreditCard
import com.example.picpaytest.data.model.Transaction
import com.example.picpaytest.data.model.User
import com.example.picpaytest.feature.contacts.ContactsActivity
import com.example.picpaytest.feature.listCard.ListCardActivity
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PaymentActivity : AppCompatActivity(), PaymentContract.View {

    override val presenter by inject<PaymentPresenter> { parametersOf(this) }

    override fun onStart() {
        super.onStart()
        presenter.getShared()
        presenter.deleteShared()
        Log.i("txe","Teste")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        setToolbar()
        recoryData()
        sendPayment.setOnClickListener {
            if(verifyValue()){
                presenter.sendPayment(valuePayment.text.toString())
            }
        }
        valuePayment.changeText {
            changeColorButton()
        }
        changeCard.setOnClickListener {
            val intentToList = Intent(this,ListCardActivity::class.java)
            startActivity(intentToList)
        }

    }


    override fun setDataScreenUser(photo: String, nickname: String) {
        photoUser.loadImage(photo)
        userNick.text = nickname
    }

    override fun setDataScreenCard(cardName: String) {
        nameCard.text = cardName
    }


    fun recoryData(){
        val card = intent.getSerializableExtra(this.resources.getString(R.string.cardRegisterToPayment)) as CreditCard
        val user = intent.getSerializableExtra(this.resources.getString(R.string.userRegisterToPayment)) as User
        presenter.setDataCard(card)
        presenter.setDataUser(user)

    }

    fun verifyValue():Boolean{
        if(!valuePayment.text.toString().isEmpty()){
            return true
        }
        return false

    }
    override fun bottomSheed(transaction: Transaction){
        val dialog = BottomSheetDialog(this)
        val viewBottom = layoutInflater.inflate(R.layout.bottom_sheet_layout,null)
        setValuesBottom(viewBottom,transaction)
        dialog.setContentView(viewBottom)
        dialog.setOnDismissListener({

            startActivity( Intent(this, ContactsActivity::class.java))
            finish()
        })
        dialog.show()

    }
    fun setValuesBottom(viewBottom:View,transaction: Transaction){
        viewBottom.bsImage.loadImage(transaction.destinationUser.img)
        viewBottom.bsUserName.text = transaction.destinationUser.username
        viewBottom.bsTime.text = presenter.convertToDate( transaction.timestamp)
        viewBottom.bsTransaction.text = "Transação: " + transaction.id
        val auxValue = transaction.value.toString().replace(".",",")
        viewBottom.bsValue.text = auxValue
        viewBottom.bsValueFinal.text = auxValue
        viewBottom.bsHolderName.text = presenter.card.holderName
    }

    override fun showError(failure: String) {
        messageDialog(this.resources.getString(R.string.pagamentoNaoConcluido),failure)
    }
    fun messageDialog(title:String,message: String){
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok", { _, _ ->
        })
        alertDialog.show()
    }
    override fun transactionRefused() {
        messageDialog(this.resources.getString(R.string.pagamentoNaoConcluido),
            this.resources.getString(R.string.possivelErroComCartao))
    }

    override fun loadViewOn() {
        loading.visibility = View.VISIBLE
    }

    override fun loadViewOff() {
        loading.visibility = View.GONE

    }
    fun changeColorButton(){
        if(verifyValue()){
            sendPayment.setBackgroundResource(R.drawable.buttonbackground)
        }else{
            sendPayment.setBackgroundResource(R.drawable.backgroundbuttongray)
        }
    }
    fun setToolbar(){
        setSupportActionBar(toolbarPayment)
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


