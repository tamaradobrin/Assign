package edu.iss.repository;

import edu.iss.entities.Document;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;

@Component
public class DocumentRepository extends AbstractJpaRepository<Document>{

    public Long getDocNumberSequence(){
        Query query = getPersistenceContext().createNativeQuery("select nextval('docnumber_seq')" );
        return ((BigInteger) query.getResultList().get(0)).longValue();
    }

}
