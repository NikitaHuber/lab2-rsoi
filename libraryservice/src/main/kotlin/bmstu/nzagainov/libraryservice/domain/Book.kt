package bmstu.nzagainov.libraryservice.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "book")
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(columnDefinition="serial")
    var book_uid: UUID? = null,

    @Column(nullable = false, length = 255)
    var name: String? = null,

    @Column(nullable = true, length = 255)
    var author: String? = null,

    @Column(nullable = true, length = 255)
    var genre: String? = null,

    @Column(nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    var condition: Condition = Condition.EXCELLENT,
)