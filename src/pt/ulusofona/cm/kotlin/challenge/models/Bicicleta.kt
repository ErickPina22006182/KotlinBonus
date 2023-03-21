package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta (identificador : String) : Veiculo(identificador) {

    override fun requerCarta() : Boolean{
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        setPosicao(x,y)
    }

    override fun toString(): String {
        return "Bicicleta | ${this.identificador} | ${this.dataDeAquisicao.day}-${this.dataDeAquisicao.month}-${this.dataDeAquisicao.year} |  ${this.posicao} | x:${this.posicao.x} | y:${this.posicao.y}"
    }
}
