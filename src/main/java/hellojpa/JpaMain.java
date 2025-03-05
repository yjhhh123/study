package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); //데이터 트랜잭션 시작
        try{
            // 객체 지향 설계 시 코드
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team); //em.persist 하면 pk값이 저장 되고 영속성 컨텍스트가 된다
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeamId(team.getId()); // 이부분이 애매하다
//            em.persist(member);

            // 객체를 테이블에 맞추어 모델링(연관 관계가 없어서) 값을 한번에 가져올 수가 없다
//            Member findMember = em.find(Member.class, member.getId());
//
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            //연관관계 매핑을 한 코드
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            //객체 지향 스럽게 코드가 나간다
            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();

            System.out.println(findTeam.getName());

            tx.commit(); //준영속 상태일 때는 아무일도 안일어 난다 커밋을 해도

        }catch(Exception e){
            tx.rollback(); //문제 생기면 롤백
        }finally{
            em.close(); //사용을 다하면 닫아주기
        }
        emf.close(); //전체 코드 끝나고 닫아주기
    }
}
