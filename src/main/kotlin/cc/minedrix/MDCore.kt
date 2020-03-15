package cc.minedrix

import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

class MDCore : JavaPlugin() {

    /**
     * Server startup
     * Builds critical functions and features during startup, Opens read-only keychain
     */
    override fun onEnable() = try {
        net = this
        clo = this.server.logger
    } catch (err: Exception) {
        err.printStackTrace()
    } finally {
        clo.info("The server is now starting up!")

        //TODO Implement feature buildup

        clo.info("Server is now online!")
    }

    /**
     * Server shutdown
     * Kicks players, Saves cache data to key, Saves keychain to database
     */
    override fun onDisable() = try {
        clo.warning("The server is now shutting down!")

        net.server.onlinePlayers.forEach { player: Player ->
            player.kickPlayer("The server had to restart... That, or the Sun just blew up!")
        }

        //TODO Implement data saving post-kick

        clo.info("The server is now offline!")
    } catch (err: Exception) {
        err.printStackTrace()
    }

    companion object {
        lateinit var net: MDCore
        lateinit var clo: Logger
    }
}