package io.github.jonashnascimento.exception;

public class ObjetoNaoEncontradoException extends RuntimeException{
    public ObjetoNaoEncontradoException() {
        super("Objeto não encontrado.");
    }
}
