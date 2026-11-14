
package br.com.pbblaze.mobilador.test

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gameUrl = "https://www.pbblaze.com.br/"

        val chromeIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(gameUrl)
        ).apply {
            setPackage("com.android.chrome")
        }

        try {
            startActivity(chromeIntent)
        } catch (e: ActivityNotFoundException) {
            try {
                startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(gameUrl))
                )
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "Browser tidak ditemukan",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        finish()
    }
}
