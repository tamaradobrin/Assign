package edu.iss.controller;

import edu.iss.entities.Document;
import edu.iss.repository.DocumentRepository;
import edu.iss.service.DocNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
@MultipartConfig
public class UploadDocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @Inject @DocNumber
    private Instance<String> docNumber;

    @GetMapping
    public String showUploadPage(Model model) {
        Document doc = new Document();
        model.addAttribute("document", doc);
        return "uploadDocument";
    }

    @PostMapping
    public RedirectView uploadFile(@RequestParam("content") MultipartFile file) {
        try {
            Document document = new Document();
            document.setContent(file.getBytes());
            document.setDocNumber(docNumber.get());
            documentRepository.create(document);
        } catch (IOException ex) {

        }
        return new RedirectView("/upload");
    }
}
