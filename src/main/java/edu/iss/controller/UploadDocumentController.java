package edu.iss.controller;

import edu.iss.entities.Document;
import java.io.IOException;

import edu.iss.repository.DocumentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.MultipartConfig;

@Controller
@RequestMapping("/upload")
@MultipartConfig
public class UploadDocumentController {

  @Autowired
  private DocumentRepository documentRepository;

  @GetMapping
  public String showUploadPage(Model model) {
    Document doc = new Document();
    model.addAttribute("document", doc);
    return "uploadDocument";
  }

  @PostMapping
  public String uploadFile(@RequestParam("content") MultipartFile file){
    try {
      Document document = new Document();
      document.setContent(file.getBytes());
      document.setDocNumber("test1");
      documentRepository.create(document
      );
    }catch (IOException ex){

    }
    return "uploadDocument";
  }
}
