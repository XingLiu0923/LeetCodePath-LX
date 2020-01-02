import java.util.HashMap;

public class scr1 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(2, 2);
        hashMap.put(1, 1);
        hashMap.put(3, 3);
        for (Integer key : hashMap.keySet()) {
            System.out.println(key);
        }
    }
}
