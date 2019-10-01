package org.improving.tag;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class ConsoleInputOutput implements InputOutput {

   // private Scanner scanner = new Scanner(System.in);
    private Scanner input;

    public ConsoleInputOutput(Scanner input) {
        this.input = input;
    }

    @Override
    public String receiveInput() {
        return input.nextLine();
    }

    @Override
    public void displayText(Object text) {
        if(!"".equals(text.toString())) {
            System.out.println(text);
        }
    }

    @Override
    public void displayNewLine() {
        System.out.println();
    }

    @Override
    public void displayPrompt(String prompt) {
        System.out.print(prompt);
    }

}
