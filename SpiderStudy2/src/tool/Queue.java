package tool;

import java.util.LinkedList;
/**
 * 队列，保存要访问的URL*/
public class Queue {
	//使用链表实现队列
	private LinkedList queue=new LinkedList();
	//进入队列
	public void enQueue(Object t){
		queue.add(t);
	}
	//出队列
	public Object deQueue(){
		return queue.removeFirst();
	}
	//判断队列是否为空
	public boolean isQueueEmpty(){
		return queue.isEmpty();
	}
	//判断队列是否含有t
	public boolean contains(Object t){
		return queue.contains(t);
	}
	public boolean empty(){
		return
				 queue.isEmpty();
	}
}
