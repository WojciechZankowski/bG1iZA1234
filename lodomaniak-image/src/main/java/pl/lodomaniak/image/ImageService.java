package pl.lodomaniak.image;

import org.springframework.web.multipart.MultipartFile;
import pl.lodomaniak.image.api.ImageUploadResponseTO;

public interface ImageService {

    ImageUploadResponseTO store(MultipartFile file);

}
