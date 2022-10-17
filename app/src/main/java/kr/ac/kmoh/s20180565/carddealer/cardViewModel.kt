package kr.ac.kmoh.s20180565.carddealer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class cardViewModel: ViewModel() {

    private var _cards = MutableLiveData<IntArray>()
    val cards: LiveData<IntArray>
        get() = _cards

    val random = Random(System.currentTimeMillis())

    fun deal() {
        var c = IntArray(5)

        for (i in c.indices)
            c[i] = random.nextInt(52)


        _cards.value = c
    }
}