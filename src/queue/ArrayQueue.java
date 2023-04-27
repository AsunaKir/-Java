package queue;

/**
 * 基于数组实现的队列
 */
public class ArrayQueue {
    // 数组：items
    private String[] items;
    // 数组大小
    private int n = 0;

    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队列
    public boolean enqueue(String item) {
        // 如果 tail == n  表示队列已经满了
        if (tail == n) return false;

        items[tail] = item;
        tail++;
        return true;
    }

    // 出队列
    public String dequeue() {
        // head == tail 表示队列为空
        if (head == tail) return null;

        String ret = items[head];
        head++;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }
}
