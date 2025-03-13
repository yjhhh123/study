package Day13;


public class IntQueue {
    private int[] que; //큐용 배열
    private int capacity; //큐의 용량
    private int front; //맨 앞의 요소 커서
    private int rear; //맨 뒤의 요소 커서
    private int num; //현재 데이터 개수

    //실행 시 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException() {
        }
    }

    //실행시 큐가 가득참
    public class OverflowIntQueseException extends RuntimeException{
        public OverflowIntQueseException(){
        }
    }

    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try{
            que = new int[capacity]; //큐 본체용 배열 생성
        }catch (OutOfMemoryError e){ //생성할 수 없음
            capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueseException{
        if(num >= capacity){
            throw new OverflowIntQueseException();
        }

        que[rear++] = x;
        num++;
        if (rear == capacity) {
            rear = 0;
        }

        return x;
    }

    public int deque() throws EmptyIntQueueException{
        if(num <= 0){
            throw new EmptyIntQueueException();
        }

        int x = que[front++];
        num--;
        if(front == capacity){
            front = 0;
        }

        return x;
    }
    
    //큐에서 프론트 데이터를 들여다봄
    public int peek() throws EmptyIntQueueException{
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    public void clear(){
        num = front = rear = 0;
    }

    public int indexOf(int x){
        for(int i = 0; i < que.length; i++){
            int idx = (i + front) % capacity;
            if(que[idx] == x){
                return idx;
            }
        }
        return -1;
    }

    public int getCapacity(){
        return capacity;
    }

    //큐에 쌓여잇는 데이터 개수 반환
    public int size(){
        return num;
    }

    public boolean isEmpty(){
        return num <= 0;
    }

    public boolean isFull(){
        return num >= capacity;
    }

    public void dump(){
        if(num <= 0){
            System.out.println("큐가 비었다");
        }
        else{
            for(int i = 0; i < num; i++){
                System.out.println(que[(i + front) % capacity] + " ");
            }
        }
    }
}
