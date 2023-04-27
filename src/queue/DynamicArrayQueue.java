package queue;

/**
 * 用数组实现动态队列
 */
public class DynamicArrayQueue {
    // 数组 items
    private String[] items;
    // 数组大小 n
    private int n = 0;

    // head 表示队头下标
    private int head = 0;
    // tail 表示队尾下标
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队操作，将items放入队尾
    public boolean enqueue(String item) {
        // tail == n 表示队列末尾没有空间了
        if (tail == n) {
            // tail == n && head == 0，表示整个队列都占满了
            if (head == 0) return false;
            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新 head 和 tail
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        return true;
    }

    // 出队列
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
