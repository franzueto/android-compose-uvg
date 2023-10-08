import com.zezzi.eventzezziapp.data.networking.MealsWebService
import com.zezzi.eventzezziapp.data.networking.response.MealsCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse? {
        return try {
            withContext(Dispatchers.IO) {
                val response = webService.getMeals().execute()
                if (response.isSuccessful) {
                    response.body()
                } else {
                    // Manejar el error de alguna manera, por ejemplo, lanzar una excepción personalizada.
                    null
                }
            }
        } catch (e: Exception) {
            // Manejar la excepción de alguna manera, por ejemplo, lanzar una excepción personalizada.
            null
        }
    }
}