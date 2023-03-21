package pt.ulusofona.cm.kotlin.challenge.exceptions

class VeiculoDesligadoException(var mensagem : String = "O veículo já está desligado") : Exception(mensagem)