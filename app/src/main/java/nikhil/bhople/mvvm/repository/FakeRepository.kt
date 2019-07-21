package nikhil.bhople.mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {

    // fake data base
    private val names : List<String> = listOf(
        "Fernando","John","Wilson","Robert","Jack","Will","Sukray","Tony","Carry","Tom")

    // We want that it can be accessed from FakeRepository only (For encapsulation)
    private val _currentRandomName = MutableLiveData<String>()

    // we want to expose it to outside
    val currentRandomName : LiveData<String>
        get() = _currentRandomName


    // when FakeRepository is created set the value of _currentRandomName
    init {
        _currentRandomName.value = names.first()
    }


    // for getting random name
    fun getRandomName(): String {
        val random = Random()
        return names[random.nextInt(names.size)]
    }

    fun changeCurrentRandomName(){
        _currentRandomName.value = getRandomName()
    }

}