import commands.Ping
import commands.Test
import dev.kord.core.Kord

suspend fun main() {
    val kord = Kord(System.getenv("TOKEN"))

    val commandsHandler = Handler(kord)

    // Command list
    commandsHandler.create(Ping(kord))
    commandsHandler.create(Test())

    commandsHandler.start()

    kord.login()
}