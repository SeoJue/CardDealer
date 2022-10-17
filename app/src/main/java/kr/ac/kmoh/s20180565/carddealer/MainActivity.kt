package kr.ac.kmoh.s20180565.carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kr.ac.kmoh.s20180565.carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model: cardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        model.cards.observe(this, Observer<IntArray> {
            val res = IntArray(5)
            for (i in it.indices) {
                res[i] = resources.getIdentifier(
                    getCardName(it[i]),
                    "drawable",
                    packageName
                )
            }
            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])
        } )


        binding.btnDeal.setOnClickListener {
            /*
            val c = IntArray(5)
            val res = IntArray(5)

            //for (i in 0..4)
            //for (i in 0 until 5)
            //for (i in 0 until c.size)
            for (i in c.indices) {
                c[i] = Random.nextInt(52)

                Log.i("Test", "${c[i]} : " + "${getCardName(c[i])}")

                res[i] = resources.getIdentifier(
                    getCardName(c[i]),
                    "drawable",
                    packageName
                )
            }
            //card1.setImageResource(R.drawable.c_2_of_hearts)
            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])
            */

            model.deal()
        }
    }

    private fun getCardName(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }

        Log.i("intput: ", c.toString())
        Log.i("shape: ", shape.toString())
        Log.i("number: ", number.toString())

        return "c_${number}_of_${shape}"
    }
}