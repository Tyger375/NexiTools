import dev.kord.core.entity.interaction.ChatInputCommandInteraction

open class SlashCommand(
    val commandData: Command,
    val action: (interaction: ChatInputCommandInteraction) -> Unit
)