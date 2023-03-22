package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity ini memungkinkan pengguna untuk melempar dadu dan
 *  melihat hasilnya di layar.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Method ini dipanggil saat Activity dibuat.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menemukan Tombol atau Button dalam tata letak
        val rollButton: Button = findViewById(R.id.button)

        // Atur click listener pada tombol untuk melempar dadu ketika user menekan tombol
        rollButton.setOnClickListener { rollDice() }

        // Melakukan lemparan dadu saat aplikasi dimulai
        rollDice()
    }

    /**
     * Lempar dadu dan perbarui layar dengan hasilnya.
     */
    private fun rollDice() {

        // Buat objek dadu atau dice dengan 6 sisi dan gulir
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Temukan ImageView dalam tata letak
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Menentukan ID drawable resource yang digunakan berdasarkan lemparan dadu
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Memperbarui ImageView dengan ID drawable resource yang benar
        diceImage.setImageResource(drawableResource)

        // Memperbarui content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Dadu dengan jumlah sisi yang tetap.
 */
class Dice(private val numSides: Int) {

    /**
     * Melakukan lemparan dadu secara acak dan mengembalikan hasilnya
     */

    fun roll(): Int {
        return (1..numSides).random()
    }
}