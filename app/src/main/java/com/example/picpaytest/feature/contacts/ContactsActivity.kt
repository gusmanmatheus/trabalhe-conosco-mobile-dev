package com.example.picpaytest.feature.contacts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.picpaytest.R
import com.example.picpaytest.data.model.User
import kotlinx.android.synthetic.main.activity_contacts.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ContactsActivity : AppCompatActivity(), ContactsContract.View {
    override val presenter by inject<ContactsPresenter> { parametersOf(this) }
    private val adapter by lazy { ContactsAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        presenter.test()
        presenter.testSendRequest()
        presenter.testUser()
        testList()
    }

    fun testList() {

        adapter.data = listOf(
            User(
                0,
                "Luffy",
                "https://vignette.wikia.nocookie.net/onepiece/images/6/6d/Monkey_D._Luffy_Anime_Post_Timeskip_Infobox.png/revision/latest?cb=20190303115209&path-prefix=pt",
                "Luffao"
            )
        )

        recyclerContacts.setHasFixedSize(true)
        recyclerContacts.layoutManager = LinearLayoutManager(this)
        recyclerContacts.adapter = adapter

        adapter.onItemClick = { item ->
            Toast.makeText(this, "Clicou no  ${item.name}", Toast.LENGTH_LONG).show()
        }

    }


}