public class SolutionWithoutStack {

    public int calculate(String s) {

        if (s == null || s.isBlank()) {
            return 0;
        }

        int lastInteger = 0;
        int currentInteger = 0;
        int result = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentInteger = (currentInteger * 10) + (currentChar - '0');
            }

            if ((!Character.isDigit(currentChar) && !Character.isSpaceChar(currentChar)) || i == s.length() - 1) {
                switch (operation) {
                    case ('+'), ('-') -> {
                        result += lastInteger;
                        lastInteger = (operation == '-') ? -currentInteger : currentInteger;
                    }
                    case ('*') ->
                        lastInteger = lastInteger * currentInteger;
                    case ('/') ->
                        lastInteger = lastInteger / currentInteger;
                    default -> {
                    }
                }
                operation = currentChar;
                currentInteger = 0;
            }
        }

        result += lastInteger;
        return result;
    }
}
