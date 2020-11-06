package bstorm.akim.SpringJPA.exception;

public class NoElementFoundException extends Exception {

    public NoElementFoundException() {
        super("Element non trouvé");
    }
}
