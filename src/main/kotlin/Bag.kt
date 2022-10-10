class Bag {
    var potion: Int = 3
    var vitamins: Int = 1

    fun itemSelect(heroes: Heroes){
        println("Choose one item from the bag.")
        println("1: ${potion}x Drank")
        println("2: ${vitamins}x Vitamin")
        var input: Int = readln().toInt()
        if (input == 1 && potion > 0){
            println("You choose the potion and your Hero heals for 50 HP")
            //var m = heroes.name
            //println(m)
            println("The fighter ${heroes.name} have 50 HP increase ")
            heroes.lifePoints += 50
            if (heroes.lifePoints > 100) heroes.lifePoints = 100
            potion--
        } else if (input == 2 && vitamins > 0){
            println("You choose the Vitamins and your hero's damage value increase by 10%")
            println("The fighter ${heroes.name} have increase value damage 10%")
            heroes.extraDamage *= 1.1
            vitamins--
        }
    }
}