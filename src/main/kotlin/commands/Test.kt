package commands

import Command
import SlashCommand
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.interaction.respondPublic
import kotlinx.coroutines.runBlocking

class Test : SlashCommand(
    commandData = Command(
        "test",
        "Time to test!"
    ) {},
    action = {
        runBlocking {
            val ids: Array<Snowflake> = Array(2) {
                Snowflake(683277796558110761)
                Snowflake(703226153678405633)
            }

            if (!ids.contains(it.user.id)) {
                it.respondPublic {
                    content = "To use this **command** you, **become** a **developer**"
                }
                return@runBlocking
            }


            it.respondPublic {
                content = "The bot is operational"
            }
        }
    }
)