package edu.iss.controller;

import edu.iss.entities.Document;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadDocumentController {

  @GetMapping
  public String showUploadPage(Model model) {
    Document doc = new Document();
    model.addAttribute("document", doc);
    return "uploadDocument";
  }

  @PostMapping
  public String uploadFile(@RequestParam("content") MultipartFile file){
    try {
      file.getBytes();
    }catch (IOException ex){

    }
    return "uploadDocument";
  }
}
