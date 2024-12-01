package bmstu.nzagainov.libraryservice.services

import bmstu.nzagainov.libraryservice.domain.Book
import bmstu.nzagainov.libraryservice.domain.Condition
import bmstu.nzagainov.libraryservice.domain.Library
import bmstu.nzagainov.libraryservice.model.BookResponse
import bmstu.nzagainov.libraryservice.model.PageableResponse
import bmstu.nzagainov.libraryservice.model.LibraryResponse
import bmstu.nzagainov.libraryservice.repository.BookLibraryRepository
import bmstu.nzagainov.libraryservice.repository.BookRepository
import bmstu.nzagainov.libraryservice.repository.LibraryRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*


@Service
class LibraryService(
    private val libraryRepository: LibraryRepository,
    private val bookRepository: BookRepository,
    private val bookLibraryRepository: BookLibraryRepository
) {

    @Transactional
    fun getLibrariesByCity(city: String, pageRequest: PageRequest): PageableResponse<LibraryResponse> {
        val libraries = libraryRepository.findAllByCity(city, pageRequest).map { it.toResponse() }
        return PageableResponse(
            page = pageRequest.pageNumber,
            pageSize = pageRequest.pageSize,
            totalElements = libraries.size,
            items = libraries
        )
    }


    @Transactional
    fun getLibraryBooks(libraryUUID: UUID, pageRequest: PageRequest) : PageableResponse<BookResponse> {
        val libraryId = libraryRepository.findAllByLibraryUid(libraryUUID).first().id
        val books = bookLibraryRepository.findAllByLibraryId(libraryId!!, pageRequest)
            .map { it.book!!.toResponse(it.availableСount!!) }
        return PageableResponse(
            page = pageRequest.pageNumber,
            pageSize = pageRequest.pageSize,
            totalElements = books.size,
            items = books
        )
    }

    fun changeBookCondition(bookUid: String, condition: Condition) {
        val book = bookRepository.findByBookUid(UUID.fromString(bookUid))
            .orElseThrow { throw EntityNotFoundException("Book $bookUid not found") }

        book.condition = condition
        bookRepository.save(book)
    }

    private fun Library.toResponse() = LibraryResponse(
        libraryUid!!,
        name!!,
        address!!,
        city!!
    )

    private fun Book.toResponse(availableCount: Int) = BookResponse(
        bookUid!!,
        name!!,
        author!!,
        genre!!,
        condition.name,
        availableCount
    )
}