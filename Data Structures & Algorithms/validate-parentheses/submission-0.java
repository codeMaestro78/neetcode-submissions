

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char current : s.toCharArray()) {
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if ((current == ')' && opening != '(') ||
                    (current == ']' && opening != '[') ||
                    (current == '}' && opening != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}