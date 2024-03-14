package com.galaxe.Controller;

import com.galaxe.Service.FileSaveService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// @Controller
@RestController
// @RequestMapping("/image")
@CrossOrigin("*")
public class FileSavingController {

  @Autowired FileSaveService fileSaveService;

  @PostMapping("/saveFile/{userEmail}/{adminId}/{travelMode}")
  public ResponseEntity<String> SaveFileInDb(
      @RequestParam("fileData") MultipartFile fileData,
      @PathVariable String userEmail,
      @PathVariable Integer adminId,
      @PathVariable String travelMode)
      throws IOException {
    System.out.println(fileData.getOriginalFilename());
    byte[] file1 = fileData.getBytes();
    System.out.println(file1);

    return new ResponseEntity<String>(
        fileSaveService.saveFileInDb(file1, userEmail, adminId, travelMode), HttpStatus.OK);
  }
}
