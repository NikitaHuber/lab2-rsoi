package bmstu.nzagainov.ratingservice.service

import bmstu.nzagainov.ratingservice.model.Rating
import bmstu.nzagainov.ratingservice.model.RatingResponse
import bmstu.nzagainov.ratingservice.repository.RatingRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class RatingService(
    private val ratingRepository: RatingRepository
) {
    fun getRating(userName: String) = ratingRepository.findByUserName(userName)
        .orElseThrow { throw EntityNotFoundException("Person $userName not found") }
        .toResponse()

    fun updateRating(userName: String, diff: Int) {
        val rating = ratingRepository.findByUserName(userName)
            .orElseThrow { throw EntityNotFoundException("Person $userName not found") }

        if (rating.stars!! + diff > 100)
            rating.stars = 100
        else if (rating.stars!! + diff < 1)
            rating.stars = 1
        else
            rating.stars = rating.stars!! + diff
        ratingRepository.save(rating)
    }

    fun addRating(user: String) {
        ratingRepository.save(Rating(userName = user, stars = 1))
    }

    private fun Rating.toResponse() = RatingResponse(stars = this.stars!!)
}