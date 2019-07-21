package nikhil.bhople.mvvm.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nikhil.bhople.mvvm.repository.FakeRepository

class MainViewModel : ViewModel() {

    val currentRandomName : LiveData<String>
        get() = FakeRepository.currentRandomName

    fun onChangeRandomClick() = FakeRepository.changeCurrentRandomName()

    // for two way data binding, use annotation @ Bindable
    @Bindable
    val editTextContent = MutableLiveData<String>()

    // Don't want to expose it to outside world
    private val _displayEditTextContent = MutableLiveData<String>()

    val displayEditTextContent: LiveData<String>
      get() = _displayEditTextContent

    fun onDisplayEditTextContentClick() {
        _displayEditTextContent.value = editTextContent.value
    }

    fun onSelectRandomEditTextFruit(){
        editTextContent.value = FakeRepository.getRandomName()
    }
}