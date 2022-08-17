package io.pragra.jpareview.exceptions;

public class BadLoginNameExpecetion extends RuntimeException {
    public BadLoginNameExpecetion(String login_is_empty) {
        super(login_is_empty);
    }
}
