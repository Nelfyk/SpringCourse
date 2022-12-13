package aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {
    public void getBook(boolean error) {
        if (error) {
            throw new RuntimeException();
        } else {
            System.out.println(">Мы берём книгу.");
        }
    }
}
