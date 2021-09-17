package se.humanit.sellshells.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import se.humanit.sellshells.entities.CaseImages;
import se.humanit.sellshells.repository.CaseImagesRepository;
import se.humanit.sellshells.service.CaseImagesService;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class CaseImagesServiceImpl implements CaseImagesService {

    private final CaseImagesRepository caseImagesRepository;

    CaseImagesServiceImpl(
            CaseImagesRepository caseImagesRepository
    ){
        this.caseImagesRepository = caseImagesRepository;
    }

    @Override
    public CaseImages store(MultipartFile file, Integer typeId, String typeName) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        CaseImages caseImages = new CaseImages(fileName, file.getContentType(), file.getBytes(),typeName,typeId);
        return caseImagesRepository.save(caseImages);
    }

    @Override
    public Stream<CaseImages> getFile(Integer typeId, String typeName) {
        return caseImagesRepository.findAllByTypeIdAndTypeName(typeId, typeName);
    }
}
