public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> W = new LinkedListDeque<Character>();
        if(word == "") {
            return  W;
        }
        W.addFirst(word.charAt(0));
        for (int i=1 ; i<word.length() ; i++) {
            W.addLast(word.charAt(i));
        }
        return W;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> c = wordToDeque(word);
        return isPalindromeHelper(c);
    }

    public boolean isPalindromeHelper(Deque<Character> D){
        if (D.size() == 1 || D.size() == 0) {
            return true;
        }
        if (D.removeFirst() != D.removeLast()) {
            return false;
        }
        return isPalindromeHelper(D);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> L = wordToDeque(word);
        if (L.size() == 0 || L.size() == 1) {
            return true;
        }
        while (L.size() > 1) {
            if (!cc.equalChars(L.removeFirst(), L.removeLast())) {
                return false;
            }
        }
        return true;
    }

}
