package Day10;

class Id{
    private static int counter = 0; //클래스 변수 (id를 몇개 부여 했는가)
    private int id; //인스턴스 변수 (id)

    public Id() { //생성자
        id = ++counter;
    }

    public static int getCounter(){ //클래스 메서드
        return counter;
    }

    public int getId(){ //인스턴스 메서드
        return id;
    }
}

public class IdTester {
    public static void main(String[] args) {
        Id a = new Id();
        Id b = new Id();

        System.out.println("a의 아이디 : " + a.getId());
        System.out.println("b의 아이디 : " + b.getId());

        System.out.println("부여한 Id 개수 : " + Id.getCounter());
    }
}
