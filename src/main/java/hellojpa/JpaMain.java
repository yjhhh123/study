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
//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("ajodpc");
//
//            //여기 아래부터 영속 상태가 됨
//            //영속성 컨텍스트가 member를 관리한다는 뜻
//            em.persist(member);
//            //하지만 이때 db에 저장되는 것이 아님
//
//            Member findmMember = em.find(Member.class, 101L);
//            //조회를 했는데 select 쿼리가 안찍힘 (1차 캐시에서 가져옴)
//
//            System.out.println(findmMember.getId());
//            System.out.println(findmMember.getName());
//
//            Member findMember1 = em.find(Member.class, 101L);
//            //이때 db에서 가져와서 영속성 컨텍스트안에 올린다
//            Member findMember2 = em.find(Member.class, 101L);
//            //영속성 컨텍스트 안의 캐시에서 값을 가져온다
//            //결론 : select 쿼리문이 한번만 찍힌다
//
//            System.out.println("result = " + (findMember1 == findMember2));

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);  //이때 쿼리가 나가는 것이 아님
//            em.persist(member2);
//            System.out.println("==================="); //쿼리가 언제 나가는지 확인하기 위함

            Member member = em.find(Member.class, 150L);
            member.setName("zzzzz");
            em.persist(member); // -> 이거는 쓰면 안된다 값을 찾아오고 변경만 한다
            tx.commit(); //트랜잭션 커밋 (정상적일 때는 커밋)
            //트랜잭션에 커밋하는 시점에 영속성에 잇는 내용이 db로 날아간다
        }catch(Exception e){
            tx.rollback(); //문제 생기면 롤백
        }finally{
            em.close(); //사용을 다하면 닫아주기
        }
        emf.close(); //전체 코드 끝나고 닫아주기
    }
}
