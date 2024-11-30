package bmstu.nzagainov.gateway.web

import bmstu.nzagainov.gateway.PathResolver
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/")
class GatewayController(private val pathResolver: PathResolver) {

    @GetMapping("/libraries")
    fun getLibraries(@RequestParam city: String, @RequestParam page: Int, @RequestParam size: Int): List<String> {
        val jsonResponse: HttpResponse<JsonNode> = Unirest.get("${pathResolver.library}libraries")
            .queryString("city", city)
            .queryString("page", page)
            .queryString("size", size)
            .asJson()
        return jsonResponse.getBody().array.map { it.toString() }
    }
}