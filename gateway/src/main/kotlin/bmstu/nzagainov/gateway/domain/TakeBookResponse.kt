package bmstu.nzagainov.gateway.domain

import java.util.*

data class TakeBookResponse(
    val reservationUid: UUID?,
    val status: Status,
    val startDate: Date,
    val tillDate: Date,
    val book: BookShortResponse,
    val library: LibraryResponse,
    val rating: RatingResponse,
)
