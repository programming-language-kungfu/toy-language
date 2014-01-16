package scanner;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private final String sourceCodeString;
    private final List<String> tokens;
    private final List<Character> operators;

    public Scanner(String sourceCodeString) {
        this.sourceCodeString = sourceCodeString;
        this.tokens = new ArrayList<String>();
        this.operators = new ArrayList<Character>();
        this.operators.add('=');
    }

    public List<String> getTokens() {

        char currentCharacter;

        for (int index = 0; index < sourceCodeString.length(); index++) {

            currentCharacter = sourceCodeString.charAt(index);

            try {
                if (Character.isWhitespace(currentCharacter)) {
                /* do nothing */
                } else if (operators.contains(currentCharacter)) {
                    tokens.add(String.valueOf(currentCharacter));
                } else if (currentCharacter == '"') {
                    index += 1;
                    StringBuilder stringBuilder = new StringBuilder();

                    char character;
                    while ((character = sourceCodeString.charAt(index)) != '"') {
                        stringBuilder.append(character);
                        index += 1;
                    }

                    tokens.add(stringBuilder.toString());
                } else if (Character.isLetter(currentCharacter)) {
                    StringBuilder stringBuilder = new StringBuilder();

                    char character;
                    while (!Character.isWhitespace(character = sourceCodeString.charAt(index))) {
                        stringBuilder.append(character);
                        index += 1;
                    }

                    tokens.add(stringBuilder.toString());
                } else if(Character.isDigit(currentCharacter)){
                    StringBuilder stringBuilder = new StringBuilder(currentCharacter);

                    char character;
                    while (Character.isDigit(character = sourceCodeString.charAt(index))) {
                        stringBuilder.append(character);
                        index += 1;

                        if(index == sourceCodeString.length()){
                            break;
                        }
                    }

                    tokens.add(stringBuilder.toString());

                } else
                    throw new IllegalArgumentException("Invalid Syntax");
            } catch (IndexOutOfBoundsException ioe) {
                break;
            }

        }

        return tokens;
    }
}
