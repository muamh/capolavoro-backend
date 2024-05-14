package com.capolavoroprova.capolavoro.Controllers;

import com.capolavoroprova.capolavoro.Services.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/upload/files")
public class UploadFileController {
    @Autowired
    private final UploadFileService uploadFileService;

    @PostMapping("/uploading")
    public String upload(@RequestParam("file")MultipartFile multipartFile){
        return this.uploadFileService.upload(multipartFile);
    }

}
