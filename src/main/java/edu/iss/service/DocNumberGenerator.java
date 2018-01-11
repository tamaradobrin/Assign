package edu.iss.service;

import edu.iss.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ApplicationScoped;
import javax.ws.rs.Produces;

@ApplicationScoped
@Component
public class DocNumberGenerator {

    @Autowired
    private DocumentRepository documentRepository;

    @Produces @DocNumber
    String getDocNumber() {
        return "doc-" + documentRepository.getDocNumberSequence();
    }

}
