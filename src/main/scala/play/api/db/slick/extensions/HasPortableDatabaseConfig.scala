package play.api.db.slick.extensions

import java.sql.{Date, Time, Timestamp}
import java.time.{LocalDate, LocalDateTime, LocalTime}

import play.api.db.slick.HasDatabaseConfig
import slick.ast.BaseTypedType
import slick.jdbc.{GetResult, JdbcProfile, JdbcType}

import scala.concurrent.Await
import scala.concurrent.duration.Duration



trait HasPortableDatabaseConfig extends HasDatabaseConfig[JdbcProfile] {

  override protected val dbConfig: PortableDatabaseConfig

  import dbConfig.profile.api._



  implicit val localDate_Date_conversion: JdbcType[LocalDate] with BaseTypedType[LocalDate] =
    MappedColumnType.base[LocalDate, Date](Date.valueOf(_), _.toLocalDate)

  implicit val localTime_Time_conversion: JdbcType[LocalTime] with BaseTypedType[LocalTime] =
    MappedColumnType.base[LocalTime, Time](Time.valueOf(_), _.toLocalTime)

  implicit val localDateTime_Timestamp_conversion: JdbcType[LocalDateTime] with BaseTypedType[LocalDateTime] =
    MappedColumnType.base[LocalDateTime, Timestamp](Timestamp.valueOf(_), _.toLocalDateTime)



  implicit val getLocalDateResult: AnyRef with GetResult[LocalDate] =
    GetResult(rs => (rs.<< : Date).toLocalDate)

  implicit val getLocalTimeResult: AnyRef with GetResult[LocalTime] =
    GetResult(rs => (rs.<< : Time).toLocalTime)

  implicit val getLocalDateTimeResult: AnyRef with GetResult[LocalDateTime] =
    GetResult(rs => (rs.<< : Timestamp).toLocalDateTime)



  def transactionally[E <: Effect, R, S <: NoStream](dBIOAction: DBIOAction[R, S, E]): DBIOAction[R, S, E with Effect.Transactional] =
    dBIOAction.transactionally

  def dbRunSync[R](a : DBIOAction[R, NoStream, Nothing], duration: Duration = Duration.Inf): R =
    Await.result(db.run(a), duration)

}
