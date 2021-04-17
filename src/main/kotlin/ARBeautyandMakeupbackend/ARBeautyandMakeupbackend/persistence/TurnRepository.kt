package ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.persistence

import ARBeautyandMakeupbackend.ARBeautyandMakeupbackend.model.Turn
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface TurnRepository : JpaRepository<Turn, Long>{


    @Query(value = "SELECT * FROM TURN turn WHERE YEAR(turn.DATE) = YEAR(:date) AND MONTH(turn.DATE) = MONTH(:date) AND DAY(turn.DATE) = DAY(:date)", nativeQuery = true)
    fun findAllByDate(date: LocalDateTime): List<Turn>


}