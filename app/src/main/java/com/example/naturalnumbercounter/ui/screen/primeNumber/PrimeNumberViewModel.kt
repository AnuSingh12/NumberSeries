import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naturalnumbercounter.datastore.DataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PrimeNumberViewModel(
    private val dataStore: DataStore
) : ViewModel() {

    private val _numbers = MutableStateFlow<List<Int>>(emptyList())
    val numbers = _numbers.asStateFlow()

    init {
        viewModelScope.launch {
            dataStore.readSeries().collect {
                _numbers.value = it
            }
        }
    }

    fun onAddClick() {
        viewModelScope.launch {

            val list = _numbers.value

            var num = if (list.isEmpty()) 997 else list.minOrNull()!! - 1

            while (!isPrime(num)) {
                num--
            }

            val updated = list + num
            dataStore.writeSeries(num)
        }
    }

    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..kotlin.math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) return false
        }
        return true
    }
}