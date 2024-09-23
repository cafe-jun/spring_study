package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        Member member = new Member();
        member.setId(1L);
        member.setName("Test");
        member.setAge(10);

        //code
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(member);
        Member member1 = em.find(Member.class, member.getId());
        member1.setName("member1");

        em.persist(member1);

        transaction.commit();
        em.close();
        emf.close();
    }
}
