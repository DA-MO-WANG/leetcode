package liuyuboo;



import java.util.*;
import java.util.Map;

public class S5942 {
    public int[] getOrder(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        HashSet<Integer> set = new HashSet<Integer>();


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }

            int three = arr[i] * 100;
            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    continue;
                }
                int two = arr[j] * 10;
                for (int q = 0; q < arr.length; q++) {
                    if (q == i || q == j || arr[q] % 2 != 0) {
                        continue;
                    }
                    int one = arr[q] * 1;
                    set.add(three + two + one);
                }

            }
        }
        int[] ret = new int[set.size()];
        int count = 0;
        for (Integer v : set) {

            ret[count++] = v;

        }
        Arrays.sort(ret);
        return ret;
    }

    //废弃
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int m = 0; m < 10; m++) {
                    set.add(i * 100 + j * 10 + m * 1);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer v : set) {
            int three = v / 100;
            int two = v / 10 % 10;
            int one = v % 100 % 10;
            int index3 = contains(digits,three);
            int index2 = contains(digits,two) ;
            int index1 = contains(digits,one);
            //if (contains(digits,three) && contains(digits,two) && contains(digits,one) && one % 2 == 0) {
              //  list.add(v);
            //}
        }
        int[] ret = new int[list.size()];
        Arrays.sort(ret);
        return ret;

    }
    public int contains(int[] arr, int v) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == v) {
                return mid;
            }else if (arr[mid] > v) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    //用字典树
    class tire {
        class Node{
            int v;
            Map<Integer, Node> next;

            public Node(int v) {
                this.v = v;
                this.next = null;
            }
        }
        Node root;
        int size;

        public void Trie() {
            this.root = new Node(-1);
            this.size = 0;
        }

        public int getSize() {
            return this.size;
        }
        //非递归版
        public void add(int[] word) {
            Node cur = this.root;
            for (int i = 0; i < word.length; i++) {
                Integer c = word[i];
                if (cur.next.get(i) == null) {
                    cur.next.put(i,new Node(c));
                }
                cur = cur.next.get(i);
            }
            //if (!cur.isWord) {
                cur.isWord = true;//字符串最后一个元素不是叶子节点，这个时候，要标志它是一个单词的结尾
                size++;
            }//如果trie中已经有这个字符串了，此时size是没有变化的，所以size++前要判断一下这个节点是不是被标志过
        }


        public boolean contains(String word) {
            Node cur = this.root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    return false;
                }
                cur = cur.next.get(c);
            }
            return cur.isWord;

        }
    }

    public int[] findEvenNumbers(int[] digits) {
        digits
    }

    public static void main(String[] args) {
        int[] arr = {0,2,0,0};
        S5942 s5942 = new S5942();
        int[] order = s5942.findEvenNumbers(arr);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }

    }
}
