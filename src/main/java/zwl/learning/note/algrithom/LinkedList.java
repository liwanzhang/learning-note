package zwl.learning.note.algrithom;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangwanli
 * @description 链表反转
 * @date 2018-09-26 下午6:13
 */
public class LinkedList {

    /*
     * 链表反转实现方式:递归实现;非递归（迭代）实现
     *
     *
     */

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Node head = ll.createLinkedList(list);
        Node newHead;

        ll.print(head);
        newHead = ll.reverseRecursion(head);
        ll.print(newHead);
        newHead = ll.reverseStack(ll.createLinkedList(list));
        ll.print(newHead);
        newHead = ll.reverseLoop(ll.createLinkedList(list));
        ll.print(newHead);
        newHead = ll.reverse(ll.createLinkedList(list));
        ll.print(newHead);
        newHead = ll.reverseDummy(ll.createLinkedList(list));
        ll.print(newHead);

        newHead = ll.reverseMove(ll.createLinkedList(list));
        ll.print(newHead);
    }

    /**
     * 递归反转
     */
    private Node reverseRecursion(Node node) {
        if (node == null || node.next == null) { //链表为空直接返回，而node->next为空是终止条件
            return node;
        }
        Node newHead = reverseRecursion(node.next);
        //通过递归，可以从倒数第二个节点开始把自己的子节点的子节点改成自己,自己的子节点改为null
        node.next.next = node;
        node.next = null;

        return newHead; //返回值只是为了控制返回的是最后一个节点
    }

    /**
     * 循环实现:基于Java Stack实现
     */
    public Node reverseStack(Node node) {
        Stack<Node> stack = new Stack<>();
        Node head = null;
        //存入栈中，模拟递归开始的栈状态
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        //特殊处理第一个栈顶元素（也就是反转前的最后一个元素，因为它位于最后，不需要反转，如果它参与下面的while， 因为它的下一个节点为空，如果getNode()， 那么为空指针异常）
        if ((!stack.isEmpty())) {
            head = stack.pop();
        }
        //排除以后就可以快乐的循环
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            temp.next.next = temp;
            temp.next = null;
        }
        return head;
    }

    /**
     * 循环实现:就地反转
     */
    private Node reverseDummy(Node head) {
        if (head == null) {
            return head;
        }
        //初始状态
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pre = dummy.next;
        Node cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = pre.next;
        }
        return dummy.next;
    }

    /**
     * 循环实现:就地反转
     */
    private Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        //初始状态
        Node temp = new Node(-1);
        temp.next = head;
        Node cur = head.next;
        while (cur != null) {
            head.next = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = head.next;
        }
        return temp.next;
    }

    /**
     * 循环实现:新建链表
     */
    public Node reverseLoop(Node head) {
        //指向空，可以想象成位于第一个节点之前
        Node newNode = null;
        //指向第一个节点
        Node cur = head;

        //循环中，使用第三变量事先保存curNode的后面一个节点
        while (cur != null) {
            Node temp = cur.next;
            //把curNode反向往前指
            cur.next = newNode;
            //newNode向后移动
            newNode = cur;
            //cur 向后移动
            cur = temp;
        }

        return newNode;
    }

    /**
     * 循环实现:遍历
     */
    static Node reverseTraversal(Node head) {
        //初始状态
        Node pre = null;
        Node cur = head;

        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     *
     */
    static Node reverseMove(Node head) {
        //初始状态
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 打印链表
     */
    private void print(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.v).append(' ');
            node = node.next;
        }

        System.out.println(sb);
    }

    /**
     * 打印链表
     */
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.v);
            System.out.print(" ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 创建链表
     */
    private Node create() {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        return head;
    }

    /**
     * 创建链表
     */
    public Node createLinkedList(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        Node cur = new Node(list.get(0));
        Node temp = createLinkedList(list.subList(1, list.size()));
        cur.next = temp;
        return cur;
    }

    /**
     * 定义节点
     */
    private static class Node {
        int v;
        Node next;

        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }

        Node(int v) {
            this(v, null);
        }

    }

}
