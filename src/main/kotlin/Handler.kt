import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.entity.interaction.ChatInputCommandInteraction
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.interaction.ChatInputCreateBuilder

class Command(
    var name: String,
    var description: String,
    var builder: ChatInputCreateBuilder.() -> Unit
)

class Handler(
    private var kord: Kord
) {
    private var actions = mutableMapOf<String, (interaction: ChatInputCommandInteraction) -> Unit>()
    fun start() {
        kord.on<GuildChatInputCommandInteractionCreateEvent> {
            val command = interaction.command

            actions[command.rootName]?.let { it(interaction) }
        }
    }

    suspend fun create(slashCommand: SlashCommand) {
        kord.createGuildChatInputCommand(
            guildId = Snowflake(795363249909923863),
            slashCommand.commandData.name,
            slashCommand.commandData.description,
            slashCommand.commandData.builder
        )
        actions[slashCommand.commandData.name] = slashCommand.action
    }

    suspend fun create(command: Command, action: (interaction: ChatInputCommandInteraction) -> Unit) {
        kord.createGuildChatInputCommand(
            guildId = Snowflake(795363249909923863),
            command.name,
            command.description,
            command.builder
        )
        actions[command.name] = action
    }
}