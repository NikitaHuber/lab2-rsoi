package bmstu.nzagainov.libraryservice.web

import bmstu.nzagainov.libraryservice.domain.Condition
import bmstu.nzagainov.libraryservice.services.LibraryService
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/")
class LibraryController(private val libraryService: LibraryService) {

    @GetMapping("libraries")
    fun getLibrariesByCity(
        @RequestParam city: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ) = libraryService.getLibrariesByCity(city, PageRequest.of(page, size))

    @GetMapping("libraries/{libraryUid}/books")
    fun getLibraryBooks(
        @PathVariable libraryUid: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
    ) = libraryService.getLibraryBooks(UUID.fromString(libraryUid), PageRequest.of(page, size))

    @PutMapping("books/{bookUid}")
    fun updateBookCondition(
        @PathVariable bookUid: String,
        @RequestParam condition: Condition,
    ) = libraryService.changeBookCondition(bookUid, condition)
}