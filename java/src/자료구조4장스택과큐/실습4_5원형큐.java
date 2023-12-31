package 자료구조4장스택과큐;

/*
 * 원형 큐로서 큐에 Item 객체를 저장 - 교재 소스코드를 원형 큐가 되도록 수정하는 연습
 *   - 원형 큐를 어려워 한다 
 * 원형 큐 실습보다는 객체들의 큐를 ArrayList로 구현하는 실습이 더 유용
 */

import java.util.Scanner;

import 자료구조4장스택과큐.objectQueue.EmptyQueueException;
import 자료구조4장스택과큐.objectQueue.OverflowQueueException;

class Item {
	int data;

	public Item(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return " < " + this.data + " > ";
	}
	
}
public class 실습4_5원형큐 {

	static final int QUEUE_SIZE = 4;
	Item[] circleQueue;
	int front, rear;
	static boolean isEmpty;
	int num;
	
	public 실습4_5원형큐() {
		//구현
		num = front = rear = 0;
		circleQueue = new Item[QUEUE_SIZE];
	}
	
	void show() {
		System.out.println("num is " + num + " front is " + front + " rear is " + rear);
		System.out.println("");
	}
	
	void push(int data) {
		//구현
		
		if(num >= QUEUE_SIZE) {
			throw new OverflowQueueException();
		}
		
		circleQueue[rear] = new Item(data);
		Item item = circleQueue[rear];
		rear++;
		num++;
		
		if(rear == QUEUE_SIZE) {
			rear = 0;
		}
		
		System.out.println(item);
	}

	Item pop() {
		//구현
		
		if(num <= 0) {
			throw new EmptyQueueException();
		}
		
		int x = circleQueue[front].data;
		Item item = new Item(x);
		front++;
		num--;
		
		if(front == QUEUE_SIZE) {
			front = 0;
		}
		
		return item;
	}

	 void clear() {
			//구현
		 num = front = rear = 0;
	}

	 void print() {
			//구현
		 for(int i = 0; i < num; i++) {
			 int idx = (i + front) % QUEUE_SIZE;
			 System.out.print(circleQueue[idx] + " ");
		 }
		 System.out.println("");
	}
	 
	// --- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

	// --- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int pick;
		실습4_5원형큐 cq = new 실습4_5원형큐();
		
		while(true) {
			
			cq.show();
			System.out.println("1. Push   2. Pop   3. Clear   4. Print	 5. Exit");
			System.out.print("명령을 선택해주세요. => ");
			pick = sc.nextInt();
			
			Item result = null;
			switch(pick){
			case 1: {
				try {
					cq.push((int)Math.round(Math.random() * 100)); 
				} catch(OverflowQueueException e) {
					System.out.println("큐가 가득찼있습니다.");
				}
				
				break;
			}
			
			case 2:
				try {
					result= cq.pop();
					System.out.println("pop: result = " + result);
				} catch (EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;
				
			case 3: cq.clear(); break;
			
			case 4: cq.print(); break;
			
			case 5: return;
			default: continue;
			}
		}

	}
}
