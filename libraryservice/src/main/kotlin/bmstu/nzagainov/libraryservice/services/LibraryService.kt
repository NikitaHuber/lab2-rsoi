package bmstu.nzagainov.libraryservice.services

import bmstu.nzagainov.libraryservice.domain.Library
import bmstu.nzagainov.libraryservice.model.LibraryResponse
import bmstu.nzagainov.libraryservice.repository.LibraryRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class LibraryService(
    private val libraryRepository: LibraryRepository
) {

    @Transactional
    fun getLibrariesByCity(city: String) = libraryRepository.findAllByCity(city).map { it.toResponse() }

    private fun Library.toResponse() = LibraryResponse(
        library_uid!!,
        name!!,
        address!!,
        city!!
    )
}