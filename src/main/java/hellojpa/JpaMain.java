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
            //영속
            Member member = em.find(Member.class, 1L);
            member.setName("hellojpa");

//            em.detach(member); //준영속 상태로 만든다 (이 값과 관련된 모든 것이 영속성 컨텍스트에서 빠지게 된다)
//            em.clear(); //영속성 컨텍스트 안의 내용을 통째로 다 지운다
            em.close(); //영속성 컨텍스트를 더이상 관리하지 않는다

            System.out.println("==================");

            tx.commit(); //준영속 상태일 때는 아무일도 안일어 난다 커밋을 해도

        }catch(Exception e){
            tx.rollback(); //문제 생기면 롤백
        }finally{
            em.close(); //사용을 다하면 닫아주기
        }
        emf.close(); //전체 코드 끝나고 닫아주기
    }
}
