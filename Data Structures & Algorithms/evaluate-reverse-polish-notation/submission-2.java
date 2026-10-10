class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/")){
                int b  = st.pop();
                int a = st.pop();

                switch(token){
                    case "+":
                        st.push(a+b);
                        break;
                    case "-":
                        st.push(a - b);
                        break;
                    case "*":
                        st.push(a*b);
                        break;
                    case "/":
                        st.push(a/b);
                        break;
                }
             }

             else{
                st.push(Integer.parseInt(token));
             }
        }
        return st.pop();
    }
}
