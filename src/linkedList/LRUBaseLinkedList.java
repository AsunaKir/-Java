package linkedList;

import java.util.Scanner;

/**
 * 基于单链表实现LRU算法
 */
public class LRUBaseLinkedList<T> {
    // 默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;

    // 头结点
    private SNode<T> headNode;

    // 链表长度
    private Integer length;

    // 链表容量
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>(); // 初始化头结点
        this.capacity = DEFAULT_CAPACITY; // 初始化容量
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data); // 获取当前元素的前一个节点

        // 链表中存在，删除原数据，插入到链表头部
        if (preNode != null) {
            deleteElemOpt(preNode); // 删除preNode节点的下一个节点
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                deleteElemAtEnd(); // 删除尾结点
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode节点的下一个元素
     * @param preNode
     */
    private void deleteElemOpt(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null; // 让 gc 回收
        length--;
    }

    /**
     * 链表头部插入节点
     * @param data
     */
    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 获取查找到元素的前一个结点
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    // 打印所有的节点
    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.println(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}

class SNode<T> {
    private T element;
    private SNode next;

    public SNode(T element) {
        this.element = element;
    }

    public SNode(T element, SNode next) {
        this.element = element;
        this.next = next;
    }

    public SNode() {
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode getNext() {
        return next;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}
