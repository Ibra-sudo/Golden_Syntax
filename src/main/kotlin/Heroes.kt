class Heroes(var name: String, var lifePoints: Int, var extraDamage: Double) {

    var magician: Magician = Magician()
    var warrior: Warrior = Warrior()
    var fighter: Fighter = Fighter()
//    var lifePointsMagician = magician.lifePoints
//    var lifePointsWarrior = warrior.lifePoints
//    var lifePointsFighter = fighter.lifePoints
//    var heroesLifePoints: Int = lifePointsMagician + lifePointsWarrior + lifePointsFighter


    fun heroesAttack(attackNum: Int): Int {

        var damage: Int = 0

        when(attackNum){
            1 -> damage = magician.magicianAttack()
            2 -> damage = warrior.warriorAttack()
            3 -> damage = fighter.fighterAttack()
        }
        return damage
    }

    fun extraDamage(damageNum: Int): Int{

        var damage: Int = 0

        when(damageNum){
            1 -> damage = magician.firstExtraDamage()
            2 -> damage = warrior.secondExtraDamage()
            3 -> damage = fighter.thirdExtraDamage()
        }
        return damage
    }
    fun heroesHealth(isHeal: Boolean): Int{
        //var heal = (5..10).random()
        if (isHeal){
            return (5..10).random()
        } else {
            return (2..8).random()
        }
    }

//    fun herosFfff(isHeal: Boolean): Int{
//        var damage = 0
//        if (isHeal){
//            return (5..10).random() * 3
//        } else {
//            return magician.magicianAttack()
//        }
//    }

}