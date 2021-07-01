package ipvc.estg.projetopmeu_gg.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoints {
    @GET("/api/utilizadorWhereNI/{nome}/{password}")
    fun getUtilizador(@Path("nome") nome: String, @Path("password") password: String): Call<Utilizador>
}