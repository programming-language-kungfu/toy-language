package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scanner {

    private final String sourceCodeString;
    private final List<String> tokens;
    private final List<Character> operators;

    public Scanner(String sourceCodeString) {
        this.sourceCodeString = sourceCodeString;
        this.tokens = new ArrayList<String>();
        this.operators = Arrays.asList('=', '+', '-', '*', '/');
    }

    public List<String> getTokens() {
        scan();
        return tokens;
    }

    private void scan() {
        char currentCharacter;

        for (int index = 0; index < sourceCodeString.length(); index++) {
            currentCharacter = sourceCodeString.charAt(index);

            try {
                index = readNextToken(currentCharacter, index);
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                break;
            }
        }
    }

    private int readNextToken(char currentCharacter, int index) {
        if (Character.isWhitespace(currentCharacter)) {
        /* do nothing */
        } else if (currentCharacter == ';') {
            tokens.add(String.valueOf(';'));
        } else if (operators.contains(currentCharacter)) {
            tokens.add(String.valueOf(currentCharacter));
        } else if(currentCharacter == '\\'){
            StringBuilder stringBuilder = new StringBuilder("\\n");
            tokens.add(stringBuilder.toString());
        }else if (currentCharacter == '"') {
            index = readString(index);
        } else if (Character.isLetter(currentCharacter)) {
            index = readWord(index);
        } else if (Character.isDigit(currentCharacter)) {
            index = readNumber(currentCharacter, index);
        } else
            throw new IllegalArgumentException("Invalid Syntax");
        return index;
    }

    private int readNumber(char currentCharacter, int index) {
        StringBuilder stringBuilder = new StringBuilder(currentCharacter);

        char character;
        while (Character.isDigit(character = sourceCodeString.charAt(index))) {
            stringBuilder.append(character);
            index += 1;

            if (index == sourceCodeString.length()) {
                break;
            }
        }

        tokens.add(stringBuilder.toString());
        return index;
    }

    private int readWord(int index) {
        StringBuilder stringBuilder = new StringBuilder();

        char character;
        while (!Character.isWhitespace(character = sourceCodeString.charAt(index))) {
            if (operators.contains(character)) {
                tokens.add(String.valueOf(character));
                break;
            }
            stringBuilder.append(character);
            index += 1;
        }

        tokens.add(stringBuilder.toString());
        return index;
    }

    private int readString(int index) {
        index += 1;
        StringBuilder stringBuilder = new StringBuilder();

        char character;
        while ((character = sourceCodeString.charAt(index)) != '"') {
            stringBuilder.append(character);
            index += 1;
        }

        tokens.add(stringBuilder.toString());
        return index;
    }
}
