package bmstu.nzagainov.libraryservice.repository

import bmstu.nzagainov.libraryservice.domain.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int>