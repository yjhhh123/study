package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //emf는 로딩 시점에 딱 하나만 만든다
        //hello sms META-INF에서 설정한 xml의 이름     <persistence-unit name="hello"> 이부분
        EntityManager em = emf.createEntityManager();
        //code db 데이터 저장, 불러오기
        //실제 db 저장 및 트랜잭션 일괄적인 한 단위를 할 때마다 EntityManager를 만들어야함
        //모든 작업은 트랜잭션 안에서 이루어 져야함

        EntityTransaction tx = em.getTransaction();
        tx.begin(); //데이터 트랜잭션 시작
        try{
            //Identity 전략
//            Member member = new Member();
//            member.setUsername("jiho10");
//
//            System.out.println("=============");
//            em.persist(member); //identity 전략의 경우 이때 insert 쿼리가 나간다 (pk값을 알아야 하기 때문)
//            System.out.println("member.id = " + member.getId());
//            System.out.println("=============");


            //Sequecne 전략
            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("==========");
            em.persist(member1); //1,51
            em.persist(member2); //메모리 호출
            em.persist(member3); //메모리 호출

            System.out.println("member1 " + member1.getId());
            System.out.println("member2 " + member2.getId());
            System.out.println("member3 " + member3.getId());
            System.out.println("==========");
            tx.commit(); //준영속 상태일 때는 아무일도 안일어 난다 커밋을 해도

        }catch(Exception e){
            tx.rollback(); //문제 생기면 롤백
        }finally{
            em.close(); //사용을 다하면 닫아주기
        }
        emf.close(); //전체 코드 끝나고 닫아주기
    }
}
