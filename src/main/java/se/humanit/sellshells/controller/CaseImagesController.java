package se.humanit.sellshells.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import se.humanit.sellshells.model.req.GetFileRequest;
import se.humanit.sellshells.model.res.ResponseFile;
import se.humanit.sellshells.service.CaseImagesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "image")
public class CaseImagesController {
    @Autowired
    private CaseImagesService caseImagesService;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("refId") Integer typeId,
            @RequestParam("refName") String typeName
    ) {
        String message = "";
        try {
            caseImagesService.store(file, typeId, typeName);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/files")
    @Transactional(readOnly = true)
    public ResponseEntity<List<ResponseFile>> getListFiles(@RequestBody GetFileRequest getFileRequest) {
        List<ResponseFile> files = caseImagesService.getFile(getFileRequest.getTypeId(), getFileRequest.getTypeName()).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId().toString())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length,
                    dbFile.getData());
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
}
