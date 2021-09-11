import java.util.Stack;

public class SolutionWithStack {

    public int calculate(String s) {

        if (s == null || s.isBlank()) {
            return 0;
        }

        Stack<Integer> integers = new Stack<>();
        char operation = '+';
        int currentInteger = 0;

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentInteger = (currentInteger * 10) + (currentChar - '0');
            }
            if ((!Character.isDigit(currentChar) && !Character.isSpaceChar(currentChar)) || i == s.length() - 1) {

                switch (operation) {
                    case '-' ->
                        integers.push(-currentInteger);
                    case '+' ->
                        integers.push(currentInteger);
                    case '*' ->
                        integers.push(integers.pop() * currentInteger);

                    case '/' ->
                        integers.push(integers.pop() / currentInteger);
                    default -> {
                    }
                }
                operation = currentChar;
                currentInteger = 0;
            }
        }

        int result = 0;
        while (!integers.isEmpty()) {
            result += integers.pop();
        }
        return result;
    }
}
