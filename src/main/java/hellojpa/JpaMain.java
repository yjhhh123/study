package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); //데이터 트랜잭션 시작
        try{
            //양방향 매핑
            //연관관계 매핑을 한 코드
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            //객체 지향 스럽게 코드가 나간다
//            Member findMember = em.find(Member.class, member.getId());
//
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for(Member m : members){
//                System.out.println("m = " + m.getName());
//            }

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

//            team.getMembers().add(member); //jpa는 읽기 전용이지만 em.flush, clear를 하지 않는다면 조회시 이 값을 읽어 올 수 없으므로 적어주는게 맞다
//          member 쪽에서 연관관계 편의 메소드를 생성하면 여기서 위의 코드를 지워도 됨
//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            for (Member member1 : members) {
                System.out.println("m = " + member1.getName());
            }

            tx.commit(); //준영속 상태일 때는 아무일도 안일어 난다 커밋을 해도
        }catch(Exception e){
            tx.rollback(); //문제 생기면 롤백
        }finally{
            em.close(); //사용을 다하면 닫아주기
        }
        emf.close(); //전체 코드 끝나고 닫아주기
    }
}
