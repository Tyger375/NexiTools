import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on

suspend fun main(args: Array<String>) {
    val kord = Kord("MTAzNjYzOTk2ODQxNzgwODM5NA.Gg-4cj.zdlilh8gPzG33KyBzm1VWHvhTK5-DrChZ41yHs");


    kord.createGlobalChatInputCommand(
        "ping",
        "Pong! Show bot ping information"
    ) {

    }

    kord.on<GuildChatInputCommandInteractionCreateEvent> {
        val response = interaction.deferPublicResponse()
        val command = interaction.command
        when (command.rootName) {
            "ping" -> {
                //Ping
                response.respond { content="\uD83C\uDFD3 Pong! `${kord.gateway.averagePing}ms`" }
            }
            else -> {
                //Default
            }
        }
    }

    kord.login();
}