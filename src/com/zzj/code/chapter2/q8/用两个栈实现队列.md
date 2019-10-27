## 题目八：用链各个栈实现队列
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和 deleteHead,
分别完成在队列尾部插入节点和在队列头部删除节点的功能。

```java
public class CQueue{
    private LinkedList<T> stack1;
    private LinkedList<T> stack2;
    
    public void appendTail(T node);
    public T    deleteHead();
}
```