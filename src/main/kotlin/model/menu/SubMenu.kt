package org.example.model.menu

class SubMenu(
    override val number: Int,
    override val name: String,
    val price: Double,
    override val description: String,
) : MainMenu(number, name, description) {
    override fun displayInfo(): String {
        val nameWithSpace = name.padEnd(14, ' ')
        val priceWithSpace = "$price\$".padStart(4, ' ')

        return "$number. $nameWithSpace  |  $priceWithSpace  |  $description"
    }
}