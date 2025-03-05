package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); //데이터 트랜잭션 시작
        try{
            // 객체 지향 적이지 못하다
//            Order order = em.find(Order.class, 1L);
//            Long memberId = order.getMemberId();
//
//            Member meberId = em.find(Member.class, memberId);

            Order order = em.find(Order.class, 2L);
            Member findMember = order.getMember();



            tx.commit(); //준영속 상태일 때는 아무일도 안일어 난다 커밋을 해도

        }catch(Exception e){
            tx.rollback(); //문제 생기면 롤백
        }finally{
            em.close(); //사용을 다하면 닫아주기
        }
        emf.close(); //전체 코드 끝나고 닫아주기
    }
}
