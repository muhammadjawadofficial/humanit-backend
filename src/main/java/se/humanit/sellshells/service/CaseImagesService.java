package se.humanit.sellshells.service;

import org.springframework.web.multipart.MultipartFile;
import se.humanit.sellshells.entities.CaseImages;

import java.io.IOException;
import java.util.stream.Stream;

public interface CaseImagesService {
    CaseImages store(MultipartFile file, Integer typeId, String typeName) throws IOException;

    Stream<CaseImages> getFile(Integer typeId, String typeName);
}
