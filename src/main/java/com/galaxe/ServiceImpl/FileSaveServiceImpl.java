package com.galaxe.ServiceImpl;

import com.galaxe.Entity.FileSaving;
import com.galaxe.Entity.User;
import com.galaxe.Repository.FileSavingRepository;
import com.galaxe.Repository.UserRepository;
import com.galaxe.Service.FileSaveService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileSaveServiceImpl implements FileSaveService {
  @Autowired private FileSavingRepository fileSavingRepository;

  @Autowired private UserRepository userRepository;

  //  public String SaveingFileInDb(FileSaving fileSaving) {
  //    fileSavingRepository.save(fileSaving);
  //    return "Image Saved";
  //  }

  @Override
  public String saveFileInDb(byte[] fileData, String userEmail, Integer adminId, String travelMode)
      throws IOException {
    FileSaving fileSaving = new FileSaving();
    // You can set the file name and description here if needed

    User user = userRepository.findByUserEmail(userEmail);

    if (user != null) {

      fileSaving.setFileData(fileData);
      fileSaving.setUser(user);
      fileSaving.setAdminId(adminId);
      fileSaving.setTravelMode(travelMode);
      fileSavingRepository.save(fileSaving);
      return "Saved successfully";
    } else {
      return "user not found";
    }
  }
}
