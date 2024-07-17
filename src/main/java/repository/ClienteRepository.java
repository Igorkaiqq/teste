/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Entity.ClienteEntity;
import com.mycompany.teste.connection.ConnectionFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author igork
 */
public class ClienteRepository {
    
    private EntityManager em;
    
    public ClienteRepository(){
        em = ConnectionFactory.getEntityManager();
    }
    
    public List<ClienteEntity> getAllClientes(){
        
        Query query = em.createQuery("Select c FROM Cliente c");
        
        return query.getResultList();
    }
    
    public void insertCliente (ClienteEntity cliente){
        em.getTransaction();
        em.persist(cliente);
        em.getTransaction().commit();
    }
    
    public void updateCliente (ClienteEntity cliente){
        em.getTransaction();
        em.merge(cliente);
        em.getTransaction().commit();
    }
    
    public ClienteEntity getCliente(Integer id) {
        ClienteEntity cliente = em.find(ClienteEntity.class, id);
        return cliente;
    }
    
    public void deleteCliente(Integer id){
        ClienteEntity cliente = getCliente(id);
        if (cliente!=null) {
            em.remove(cliente);
        }
    }
    
}
