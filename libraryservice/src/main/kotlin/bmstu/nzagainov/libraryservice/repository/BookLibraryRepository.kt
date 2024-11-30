package bmstu.nzagainov.libraryservice.repository

import bmstu.nzagainov.libraryservice.domain.BookLibrary
import bmstu.nzagainov.libraryservice.domain.RelationshipIdClass
import org.springframework.data.jpa.repository.JpaRepository

interface BookLibraryRepository : JpaRepository<BookLibrary, RelationshipIdClass>