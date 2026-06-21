package controller;



import javax.persistence.*;

import model.Produto;

import java.util.List;

public class ProdutoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CadastroPU");

    public void create(Produto p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Produto p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Produto p = em.find(Produto.class, id);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    public Produto find(int id) {
        EntityManager em = emf.createEntityManager();
        Produto p = em.find(Produto.class, id);
        em.close();
        return p;
    }

    public List<Produto> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Produto> lista = em.createQuery("FROM Produto", Produto.class).getResultList();
        em.close();
        return lista;
    }
}
