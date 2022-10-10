fun main() {
    println("Start the Game: ")

    var boss: Boss = Boss("dragon", 10000)
    var heroes: Heroes = Heroes("magician", 100, 1.1)
    var bag: Bag = Bag()
    var magician: Heroes = Heroes("magician", 100, 1.1)
    var warrior: Heroes = Heroes("warrior", 100, 1.1)
    var fighter: Heroes = Heroes("fighter", 100, 1.1)
    var lifePointsMagician = magician.lifePoints
    var lifePointsWarrior = warrior.lifePoints
    var lifePointsFighter = fighter.lifePoints
    var lifePointsHeroes: Boolean = lifePointsMagician <= 0 && lifePointsWarrior <= 0 && lifePointsFighter <= 0


    println("Your available attacks:")

    println("1: Magician")
    println("2: Warrior")
    println("3: Fighter")

    println("The Compat is begin!")

    var roundCount: Int = 1
    var bagUsed: Boolean
    var blockedFighter: Int

    while (!lifePointsHeroes && (boss.lifePoints > 0)) {
        println("Round $roundCount:")
        var bagUsed = chooseBag(magician, warrior, fighter, bag)
        blockedFighter = blockFighter(bagUsed)
        println("Your $blockedFighter fighter has been blocked!")
        if (blockedFighter != 1){
            println("Fighter One attacks")
            heroesAttacks(magician, boss)
        }
        if (blockedFighter != 2){
            println("Fighter Two attacks")
            heroesAttacks(warrior, boss)
        }
        if (blockedFighter != 3){
            println("Fighter Three attacks")
            heroesAttacks(fighter, boss)
        }
        if (boss.lifePoints > 0) bossAttacks(magician, warrior, fighter, boss)
        if (boss.helper.lifePoints <= 0){
            println("Now you fight The big Boss")
            heroesAttacks(heroes, boss)
        }
        roundCount ++
    }

    println("The compat is done.")

    if ((magician.lifePoints <= 0) && (warrior.lifePoints <= 0) && (fighter.lifePoints <= 0)){
        println("You Lose")
    }

    if (boss.lifePoints <= 0 ){
        println("You win!")
    }
}


fun bossAttacks(fighterOne: Heroes, fighterTwo: Heroes, fighterThree: Heroes , boss: Boss) {
    var bossDamage: Int = boss.bossAttack()
    var bossHelperDamage: Int = boss.helper.helperAttack()
    if (boss.helperReady){
        if (boss.helperReady && boss.helper.lifePoints > 0 && fighterOne.lifePoints > 0){
            fighterOne.lifePoints -= bossHelperDamage
        } else if(boss.helperReady && boss.helper.lifePoints > 0 && fighterTwo.lifePoints > 0){
            fighterTwo.lifePoints -= bossHelperDamage
        } else if(boss.helperReady && boss.helper.lifePoints > 0 && fighterThree.lifePoints > 0){
            fighterThree.lifePoints -= bossHelperDamage
        }
            println("Your heroesH have damaged: -$bossHelperDamage HP.")
            println("Lifepoints fighter 1 decrease: ${fighterOne.lifePoints} HP.")
            println("Lifepoints fighter 2 decrease: ${fighterTwo.lifePoints} HP.")
            println("Lifepoints fighter 3 decrease: ${fighterThree.lifePoints} HP.")
    } else {
        println("The Boss will attack!")
        if (fighterOne.lifePoints > 0){
            fighterOne.lifePoints -= bossDamage
        } else if (fighterTwo.lifePoints > 0){
            fighterTwo.lifePoints -= bossDamage
        } else if (fighterThree.lifePoints > 0){
            fighterThree.lifePoints -= bossDamage
        }
        println("Your heroes have damaged: -$bossDamage HP.")
        println("Lifepoints fighter 1 decrease: ${fighterOne.lifePoints} HP.")
        println("Lifepoints fighter 2 decrease: ${fighterTwo.lifePoints} HP.")
        println("Lifepoints fighter 3 decrease: ${fighterThree.lifePoints} HP.")
    }
}
fun heroesAttacks(heroes: Heroes, boss: Boss) {
    println("Chose your next attack!: ")
    var heroesMove: Int = readln().toInt()
    var heroesDamage: Int = heroes.heroesAttack(heroesMove)
    if (boss.helperReady && boss.helper.lifePoints > 0){
        boss.helper.lifePoints -= heroesDamage
        println("The BossHelper have damaged: -$heroesDamage HP.")
        println("Lifepoints decrease: ${boss.helper.lifePoints} HP.")
    } else {
        boss.lifePoints -= heroesDamage
        println("The Boss have damaged: -$heroesDamage HP.")
        println("Lifepoints decrease: ${boss.lifePoints} HP.")
    }
    if (boss.helperReady)
        println("The lifePoints of the Boss helper ${boss.helper.lifePoints}")
}
//fun heroesHealth(heroes: Heroes, boss: Boss){
//    var isHealth = false
//    var heroHealth: Int = heroes.heroesHealth(isHealth)
//    heroes.heroesLifePoints += heroHealth
//    println("The have health bounos: +$heroHealth HP.")
//    println("Lifepoints increase: ${heroes.heroesLifePoints} HP.")
//}
fun chooseBag(fighterOne: Heroes, fighterTwo: Heroes, fighterThree: Heroes, bag: Bag): Boolean {
    var bagSelected: Boolean = false
    println("Do you want use the Bag? J/N")
    var input: String = readln().uppercase()
    if (input == "J"){
        println("Choose a Hero (1|2|3)")
        var fighterNum: Int = readln().toInt()
        if (fighterNum == 1) bag.itemSelect(fighterOne)
        if (fighterNum == 2) bag.itemSelect(fighterTwo)
        if (fighterNum == 3) bag.itemSelect(fighterThree)
        bagSelected = true
    }
    return bagSelected
}
fun blockFighter(bagUsed: Boolean): Int{
    var blockedFighter = 0
    if (bagUsed) blockedFighter = listOf(1, 2, 3).random()
    return blockedFighter
}