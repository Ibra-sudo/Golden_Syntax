class Magician(){
    //var attack: Boolean = false
    var name: String = "magician"
    var lifePoints: Int = 100
    var damage: Int = 0
    var extraDamage: Double = 1.0

    fun magicianAttack(): Int{
        //attack = true
        damage += (10..30).random()

        return damage
    }
    fun firstExtraDamage(): Int{
        return (extraDamage * 10).toInt()
    }

}