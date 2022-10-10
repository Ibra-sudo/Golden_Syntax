class Warrior(){
    //var attack: Boolean = false
    var name: String = "warrior"
    var damage: Int = 0
    var lifePoints: Int = 100
    var extraDamage: Double = 1.0

    fun warriorAttack(): Int {
        //attack = true
        damage += (5..20).random()

        return damage
    }
    fun secondExtraDamage(): Int{
        return (extraDamage * 20).toInt()
    }

}