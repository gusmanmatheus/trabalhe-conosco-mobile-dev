package com.example.picpaytest.feature.contacts

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.picpaytest.R
import com.example.picpaytest.base.changeText
import com.example.picpaytest.data.model.User
import com.example.picpaytest.feature.primingCard.PrimingActivity
import kotlinx.android.synthetic.main.activity_contacts.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ContactsActivity : AppCompatActivity(), ContactsContract.View {
    override val presenter by inject<ContactsPresenter> { parametersOf(this) }
    private val adapter by lazy { ContactsAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        presenter.getUsers()
        searchContacts.changeText {
            var filter = searchContacts.text.toString()
            presenter.filterList(filter)
        }
    }
    private fun setupList() {
        recyclerContacts.setHasFixedSize(true)
        recyclerContacts.layoutManager = LinearLayoutManager(this)
        recyclerContacts.adapter = adapter
    }
    override fun setListUsers(users: ArrayList<User>) {
        adapter.data = users
        adapter.onItemClick = {user ->
            Toast.makeText(this,"Clickou no  ${user.name}",Toast.LENGTH_LONG).show()
            val intent = Intent(this,PrimingActivity::class.java)
            intent.putExtra(this.resources.getString(R.string.contactsToPriming),user)
            startActivity(intent)
        }
        setupList()
    }
    override fun showError(error: String) {
        Toast.makeText(this,"ERRRO: $error",Toast.LENGTH_SHORT).show()
    }
    override fun recoveryUsers(users: ArrayList<User>) {
        setListUsers(users)
    }
}


