import com.zezzi.eventzezziapp.data.networking.response.MealResponse
import kotlinx.coroutines.flow.MutableStateFlow

data class MealsCategoriUiState(
     private val _categories: MutableStateFlow<List<MealResponse>> = MutableStateFlow(emptyList())
) {
     val categories: MutableStateFlow<List<MealResponse>> get() = _categories

     fun updateCategories(newCategories: List<MealResponse>) {
          _categories.value = newCategories
     }
}
