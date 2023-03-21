package pt.ulusofona.cm.kotlin.challenge.exceptions

class VeiculoNaoEncontradoException(var mensagem : String = "Não foi possível encontrar o veículo procurado") : Exception(mensagem)