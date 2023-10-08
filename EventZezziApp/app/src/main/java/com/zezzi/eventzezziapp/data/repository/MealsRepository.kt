import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return withContext(Dispatchers.IO) {
            try {
                // Llamar a la función suspendida en el webService para obtener los datos.
                val response = webService.getMeals()
                Result.success(response).getOrNull()

            } catch (e: Exception) {
                // Manejar errores si es necesario.
                null
            }
        }
    }
}