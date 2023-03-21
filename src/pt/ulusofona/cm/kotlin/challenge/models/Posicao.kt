package pt.ulusofona.cm.kotlin.challenge.models

class Posicao (var x : Int = 0, var y : Int = 0){
    fun alterarPosicaoPara(x : Int, y : Int){
        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }
}
