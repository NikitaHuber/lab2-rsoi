package bmstu.nzagainov.libraryservice.repository

import bmstu.nzagainov.libraryservice.domain.BookLibrary
import bmstu.nzagainov.libraryservice.domain.RelationshipIdClass
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookLibraryRepository : JpaRepository<BookLibrary, RelationshipIdClass> {
    fun findAllByLibraryId(libraryId: Int, pageable: Pageable): List<BookLibrary>
}