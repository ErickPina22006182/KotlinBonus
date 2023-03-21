package pt.ulusofona.cm.kotlin.challenge.exceptions

class MenorDeIdadeException(var mensagem : String = "Pessoa tem menos de 18 anos") : Exception(mensagem)