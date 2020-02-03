import java.util.ArrayList;
import java.util.List;

public class Q17_test1 {
    public List<String> letterCombinations(String digits) {
        List<Character>[] dic = new List[10];
        for (int i = 0; i < 10; i++) {
            dic[i] = new ArrayList<>();
        }
        dic[2].add('a'); dic[2].add('b'); dic[2].add('c');
        dic[3].add('d'); dic[3].add('e'); dic[3].add('f');
        dic[4].add('g'); dic[4].add('i'); dic[4].add('h');
        dic[5].add('j'); dic[5].add('k'); dic[5].add('l');
        dic[6].add('m'); dic[6].add('n'); dic[6].add('o');
        dic[7].add('p'); dic[7].add('q'); dic[7].add('r'); dic[7].add('s');
        dic[8].add('t'); dic[8].add('u'); dic[8].add('v');
        dic[9].add('w'); dic[9].add('x'); dic[9].add('y'); dic[9].add('z');
        return letterCombinations(digits, dic);
    }

    private List<String> letterCombinations(String digits, List<Character>[] dic) {
        List<String> list = new ArrayList<>();
        int n = digits.length();
        if (n == 0) return list;
        char c = digits.charAt(0);
        List<String> nextList = letterCombinations(digits.substring(1, n), dic);
        if (c == '0' || c == '1') return nextList;
        if (nextList.isEmpty()) {
            for (char each : dic[c - '0']) list.add(String.valueOf(each));
        }
        for (String each : nextList) {
            for (char letter : dic[c - '0']) {
                list.add(letter + each);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Q17_test1().letterCombinations("22");
    }
}
