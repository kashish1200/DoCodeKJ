class Solution {
    public boolean isPalindrome(int x) {
        // Handle negative numbers, which cannot be palindromes
        if (x < 0) {
            return false;
        }

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int temp = x;

        // Split digits and push into stack and arraylist
        while (temp > 0) {
            st.push(temp % 10);
            arr.add(temp % 10);
            temp = temp / 10;
        }

        // Compare stack pop with array list
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != st.pop()) {
                return false;
            }
        }

        return true; // The number is a palindrome if we passed all checks
    }
}
