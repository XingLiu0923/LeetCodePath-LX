public class Q294_test1 {
    public boolean canWin(String s) {
        int n = s.length();
        if (n == 0) return false;
        char[] cards = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (cards[i] == '+' && cards[i - 1] == '+') {
                cards[i] = '-'; cards[i - 1] = '-';
                if (flipAnyCardsWin(cards)) return true;
                cards[i] = '+'; cards[i - 1] = '+';
            }
        }
        return false;
    }

    private boolean flipAnyCardsWin(char[] cards) {
        int n = cards.length;
        for (int i = 1; i < n; i++) {
            if (cards[i] == '+' && cards[i - 1] == '+') {
                cards[i] = '-'; cards[i - 1] = '-';
                if (!canWin(String.valueOf(cards))) {
                    cards[i] = '+'; cards[i - 1] = '+';
                    return false;
                }
                cards[i] = '+'; cards[i - 1] = '+';
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Q294_test1().canWin("++++");
    }
}
