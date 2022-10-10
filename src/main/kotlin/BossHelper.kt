class BossHelper(){
    var lifePoints: Int = 250

    fun helperAttack(): Int {
        var attacks: List<Int> = listOf(1, 2, 3, 4)
        var attackNum: Int = attacks.random()

        var damage: Int = 0

        when(attackNum){
            1 -> damage = firstShot()
            2 -> damage = secondShot()
            3 -> damage = thirdShot()
            4 -> damage = fourthShot()
        }
        return damage
    }

    private fun firstShot(): Int {
        return 10
    }
    private fun secondShot(): Int {
        return 15
    }
    private fun thirdShot(): Int {
        return 20
    }
    private fun fourthShot(): Int {
        return 25
    }
}