package play.api.db.slick.extensions

import com.typesafe.config.Config
import slick.basic.DatabaseConfig
import slick.jdbc.{JdbcBackend, JdbcProfile}



class PortableDatabaseConfig(
  wrappedDbConfig: DatabaseConfig[JdbcProfile]
) extends DatabaseConfig[JdbcProfile] {

  override def db: JdbcBackend#DatabaseDef = wrappedDbConfig.db
  override val profile: JdbcProfile = wrappedDbConfig.profile
  override val driver: JdbcProfile = wrappedDbConfig.profile
  override def config: Config = wrappedDbConfig.config
  override def profileName: String = wrappedDbConfig.profileName
  override def profileIsObject: Boolean = wrappedDbConfig.profileIsObject

}

object PortableDatabaseConfig {

  def apply(path: String): PortableDatabaseConfig =
    new PortableDatabaseConfig(DatabaseConfig.forConfig(path))
}
