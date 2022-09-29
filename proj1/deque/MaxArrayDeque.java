package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public MaxArrayDeque(Comparator<T> c, T bacon) {
        this(c);
        this.addFirst(bacon);
    }

    public T max(Comparator<T> c) {
        T max = get(0);

        for (int i = 1; i < size(); i += 1) {
            T currentBacon = get(i);
            if (c.compare(max, currentBacon) < 0) {
                max = currentBacon;
            }
        }
        return max;
    }

    public T max() {
        return max(comparator);
    }

    private static void main(String[] args) {
        Comparator<Integer> cmp = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        MaxArrayDeque mad1 = new MaxArrayDeque(cmp);

        int n = 99;

        for (int i = n; i >= 0; i--) {
            mad1.addFirst(i);
        }

        System.out.println(mad1.max());
        System.out.println(mad1.max(cmp));

        Comparator<String> cmp2 = new Comparator<>() {
            //重写排序方法
            @Override
            public int compare(String strA, String strB) {
                return strA.compareTo(strB);
            }
        };

        MaxArrayDeque mad2 = new MaxArrayDeque(cmp2);

        mad2.addFirst("front");
        mad2.addLast("middle");
        mad2.addLast("back");

        System.out.println(mad2.max());
        System.out.println(mad2.max(cmp2));
    }

}