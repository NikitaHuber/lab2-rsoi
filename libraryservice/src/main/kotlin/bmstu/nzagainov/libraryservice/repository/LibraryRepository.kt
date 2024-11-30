package bmstu.nzagainov.libraryservice.repository

import bmstu.nzagainov.libraryservice.domain.Library
import org.springframework.data.jpa.repository.JpaRepository

interface LibraryRepository : JpaRepository<Library, Int> {
    fun findAllByCity(city: String): List<Library>
}