class Boss(var name: String, var lifePoints: Int) {
    //var attack: Boolean = false
    //var health: Int = 150
    //var damage: Int = 0
    var helper: BossHelper = BossHelper()
    var helperReady: Boolean = false

    fun bossAttack(): Int {
        var attacks: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
        if(helperReady) attacks.remove(5)
        println(attacks)
        var attackNum: Int = attacks.random()

        var damage: Int = 0

        when(attackNum){
            1 -> damage = firstShot()
            2 -> damage = secondShot()
            3 -> damage = thirdShot()
            4 -> damage = fourthShot()
            5 -> bossHelper()
        }
        return damage
    }

    private fun firstShot(): Int {
        return 45
    }
    private fun secondShot(): Int {
        return 45
    }
    private fun thirdShot(): Int {
        return 45
    }
    private fun fourthShot(): Int {
        return 45
    }
    private fun bossHelper() {
        println("Boss Helper was called!")
        helperReady = true

    }

}