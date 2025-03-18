import jakarta.persistence.*;
import java.util.List;
//Pedro Bonelli Mecca Pinto
//Pedro Henrique Belini

public class AlunoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
    private EntityManager em = emf.createEntityManager();

    public void cadastrar(Aluno aluno) {
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
    }

    public void excluir(Long id) {
        em.getTransaction().begin();
        Aluno aluno = em.find(Aluno.class, id);
        if (aluno != null) {
            em.remove(aluno);
        }
        em.getTransaction().commit();
    }

    public void alterar(Aluno aluno) {
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
    }

    public Aluno buscarPorNome(String nome) {
        TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a WHERE a.nome = :nome", Aluno.class);
        query.setParameter("nome", nome);
        List<Aluno> alunos = query.getResultList();
        return alunos.isEmpty() ? null : alunos.get(0);
    }

    public Aluno buscarPorId(Long id) {
        return em.find(Aluno.class, id);
    }

    public List<Aluno> listarTodos() {
        return em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
    }
}
