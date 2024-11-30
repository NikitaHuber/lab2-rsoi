package bmstu.nzagainov.libraryservice.web

import bmstu.nzagainov.libraryservice.services.LibraryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class LibraryController(private val libraryService: LibraryService) {

    @GetMapping("/libraries")
    fun getLibrariesByCity(@RequestParam city: String) = libraryService.getLibrariesByCity(city)
}