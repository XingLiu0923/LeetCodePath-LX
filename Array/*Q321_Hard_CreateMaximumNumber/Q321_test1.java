import java.util.*;

public class Q321_test1 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[k];int i = 0;
        HashSet<String> nextBegins = new HashSet<>();
        SegmentTree st1 = new SegmentTree(nums1), st2 = new SegmentTree(nums2);
        int[] begin = {0, 0};
        nextBegins.add(pairs(begin[0], begin[1]));
        while (k > i) {
            HashSet<String> tmpBegins = new HashSet<>();
            int maxNum = -1;
            for (String pair : nextBegins){
                begin = pairsValue(pair);
                int end1 = Math.min(m + n - k - begin[1] + i, m - 1), end2 = Math.min(m + n - k + i - begin[0], n - 1);
                int max1 = st1.queryMax(begin[0], end1), max2 = st2.queryMax(begin[1], end2);
                if (max1 != -1)
                    if (nums1[max1] > maxNum) {
                        tmpBegins.clear();
                        System.out.println(1);
                        maxNum = nums1[max1];
                        tmpBegins.add(pairs(max1 + 1, begin[1]));
                    } else if (nums1[max1] == maxNum) {
                        tmpBegins.add(pairs(max1 + 1, begin[1]));
                    }
                if (max2 != -1) {
                    if (nums2[max2] > maxNum) {
                        tmpBegins.clear();
                        maxNum = nums2[max2];
                        tmpBegins.add(pairs(begin[0], max2 + 1));
                    } else if (nums2[max2] == maxNum) {
                        tmpBegins.add(pairs(begin[0], max2 + 1));
                    }
                }
            }
            result[i++] = maxNum;
            nextBegins = tmpBegins;
        }
        return result;
    }

    private String pairs(int begin, int end) {
        return begin + " " + end;
    }

    private int[] pairsValue(String pairs) {
        String[] pair = pairs.split(" ");
        return new int[] {Integer.valueOf(pair[0]), Integer.valueOf(pair[1])};
    }

    // 返回的是最大的位置
    private class SegmentTree {
        class Node {
            int data;
            int begin, end;
            int mark;

            Node(int begin, int end) {
                data = 0; this.begin = begin; this.end = end; mark = 0;
            }

            protected void setData(int val) {
                data = val;
            }
        }

        private Node[] tree;
        private int[] data;

        SegmentTree(int[] base) {
            int n = base.length;
            tree = new Node[4 * n + 2];
            data = base;
            build(0, 0, n - 1, base);
        }

        private void build(int i, int begin, int end, int[] base) {
            if (end < begin) return;
            tree[i] = new Node(begin, end);
            if (end == begin) {
                tree[i].data = begin;
                return;
            }
            int mid = begin + (end - begin)/2;
            build(2 * i + 1, begin, mid, base);
            build(2 * i + 2, mid + 1, end, base);
            if (base[tree[2 * i + 1].data] > base[tree[2 * i + 2].data]) tree[i].data = tree[2 * i + 1].data;
            else if (base[tree[2 * i + 1].data] < base[tree[2 * i + 2].data]) tree[i].data = tree[2 * i + 2].data;
            else tree[i].data = Math.min(tree[2 * i + 1].data, tree[2 * i + 2].data);
        }

        protected int queryMax(int begin, int end) {
            return queryMax(0, begin, end);
        }

        private int queryMax(int i, int begin, int end) {
            if (begin > end || tree[i].end < begin || tree[i].begin > end) return -1;
            if (tree[i].begin >= begin && tree[i].end <= end) return tree[i].data;
            int left = queryMax(2 * i + 1, begin, end), right = queryMax(2 * i + 2, begin, end);
            if (left == -1) return right;
            else if (right == -1) return left;
            else if (data[left] < data[right]) return right;
            else if (data[left] > data[right]) return left;
            else return Math.min(left, right);
        }
    }
}
