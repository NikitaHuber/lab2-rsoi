package bmstu.nzagainov.libraryservice.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "library")
data class Library(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(columnDefinition="serial")
    var library_uid: UUID? = null,

    @Column(nullable = false, length = 80)
    var name: String? = null,

    @Column(nullable = false, length = 255)
    var city: String? = null,

    @Column(nullable = false, length = 255)
    var address: String? = null,
)