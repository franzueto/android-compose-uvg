import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import com.zezzi.eventzezziapp.data.repository.MealsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    private val _categories: MutableStateFlow<List<MealResponse>> = MutableStateFlow(emptyList())
    val categories: StateFlow<List<MealResponse>> get() = _categories

    fun getMeals() {
        viewModelScope.launch {
            val meals = repository.getMeals()
            _categories.value = meals.categories
        }
    }
}
