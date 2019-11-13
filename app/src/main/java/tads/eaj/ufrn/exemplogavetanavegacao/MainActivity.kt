package tads.eaj.ufrn.exemplogavetanavegacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import android.view.View
import android.widget.PopupMenu


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            Toast.makeText(this@MainActivity, "ID:$id", Toast.LENGTH_SHORT).show()
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

        fab.setOnClickListener {
            Snackbar.make(
                coordinator,
                "Replace with your own action",
                Snackbar.LENGTH_LONG
            ).setAction("Action", null).show()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_app, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_search) {
            Toast.makeText(this, "Pesquisa", Toast.LENGTH_SHORT).show()
            true
        } else super.onOptionsItemSelected(item)

    }

    fun clicaImagem(v: View) {
        // inflate menu
        val popup = PopupMenu(this@MainActivity, v)
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.menu_imagem, popup.menu)
        popup.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                return when (item.itemId) {
                    R.id.navigation_item_1 -> {
                        Toast.makeText(this@MainActivity, "Opção1", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.navigation_item_2 -> {
                        Toast.makeText(this@MainActivity, "Opção2", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        })
        popup.show()
    }
}