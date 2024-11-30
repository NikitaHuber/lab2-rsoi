package bmstu.nzagainov.libraryservice.domain

import jakarta.persistence.*

@Entity
@Table(name = "library_books")
@IdClass(RelationshipIdClass::class)
data class BookLibrary(

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    val book: Book,

    @Id
    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false)
    val library: Library,

    @Column(nullable = false)
    val available_count: Int,
)