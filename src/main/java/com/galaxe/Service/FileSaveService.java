package com.galaxe.Service;

import java.io.IOException;

public interface FileSaveService {
  //  public String SaveingFileInDb(FileSaving fileSaving);

  //  public String SaveingFileInDb(MultipartFile fileData, String fileName, String fileDescription)
  //      throws IOException;
  //
  //  String SaveingFileInDb(Byte[] fileData, String fileName, String fileDescription)
  //      throws IOException;

  public String saveFileInDb(byte[] fileData, String userEmail, Integer adminId, String travelMode)
      throws IOException;
}
