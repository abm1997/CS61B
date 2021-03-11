import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome(" "));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("kk"));
        assertTrue(palindrome.isPalindrome("abaaba"));
        assertTrue(palindrome.isPalindrome("mynaanym"));
        assertFalse(palindrome.isPalindrome("mynaanYm"));
        assertFalse(palindrome.isPalindrome("abaab"));
        assertFalse(palindrome.isPalindrome("ab aaba"));
        assertFalse(palindrome.isPalindrome("myname"));

        OffByOne offbyone = new OffByOne();
        assertTrue(palindrome.isPalindrome("abb", offbyone));
        assertTrue(palindrome.isPalindrome("flake", offbyone));
        assertTrue(palindrome.isPalindrome(" ", offbyone));
        assertTrue(palindrome.isPalindrome("", offbyone));
        assertTrue(palindrome.isPalindrome("FWXXG", offbyone));
        assertTrue(palindrome.isPalindrome("#}c|$", offbyone));
        assertFalse(palindrome.isPalindrome("FWXzG", offbyone));
        assertFalse(palindrome.isPalindrome("ahB", offbyone));
    }
}