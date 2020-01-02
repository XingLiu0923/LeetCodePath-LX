public class Q84_test1 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] minIndex = new int[n];
        int size = 0, maxPos = 0, origin = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] == 0) { size = 0; origin = i + 1; continue; }
            while (size > 0 && heights[minIndex[size - 1]] > heights[i]) size--;
            minIndex[size++] = i;
            if (maxPos >= size) maxPos = size - 1;
            for (int j = maxPos; j < size; j++) {
                int area = j == 0 ? ((i + 1 - origin) * heights[minIndex[j]]) : ((i - minIndex[j - 1]) * heights[minIndex[j]]);
                // if (area > (i - minIndex[maxPos]) * heights[minIndex[j]]) maxPos = j;
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = { 2060480,88006971,69429928,14769417,62734638,76649267,49994447,40244588,15031329,24952803,30749664,64488634,64268553,48766239,89826916,10046542,68413513,53189093,56940081,10253343,83309670,81743514,69411542,35280637,89545603,69482381 };
        new Q84_test1().largestRectangleArea(a);
        int[] b = {2060480,88006971,69429928,14769417,62734638,76649267,49994447,40244588,15031329,24952803,30749664,64488634,64268553,48766239,89826916,10046542,68413513,53189093,56940081,10253343,83309670,81743514,69411542,35280637,89545603,69482381};
        for (Integer each : b) {
            if (241117008%each == 0) System.out.println(251163550/each+"  " + each);
            System.out.print(each/1000000+"," + (each > 10046542));
        }
    }
}
