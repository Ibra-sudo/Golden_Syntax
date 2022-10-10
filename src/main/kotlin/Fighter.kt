class Fighter(){
    //var attack: Boolean = false
    var name: String = "fighter"
    var damage: Int = 0
    var lifePoints: Int = 100
    var extraDamage: Double = 1.0

    fun fighterAttack(): Int {
        //attack = true
        damage += (5..20).random()

        return damage
    }
    fun thirdExtraDamage(): Int{
        return (extraDamage * 30).toInt()
    }


}