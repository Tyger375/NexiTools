package commands

import Command
import SlashCommand
import dev.kord.core.Kord
import dev.kord.core.behavior.interaction.respondPublic
import kotlinx.coroutines.runBlocking

class Ping(
    private val kord: Kord
) : SlashCommand(
    commandData = Command(
        "ping",
        "ping command"
        ) {},
    action = {
        runBlocking {
                /*
                Another method to reply.

                val response = it.deferPublicResponse()

                val allEmbeds = mutableListOf<EmbedBuilder>()
                val embed = EmbedBuilder()
                embed.description = "Pong! ${kord.gateway.averagePing}"
                allEmbeds.add(embed)
                response.respond {
                    embeds = allEmbeds
                }
                */
            it.respondPublic {
                content = "\uD83C\uDFD3 Pong! `${kord.gateway.averagePing}`"
            }
        }
    }
)