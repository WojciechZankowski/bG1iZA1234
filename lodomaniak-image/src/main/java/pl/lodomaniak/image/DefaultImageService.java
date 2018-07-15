package pl.lodomaniak.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.lodomaniak.core.exception.LodomaniakSystemException;
import pl.lodomaniak.image.api.ImageUploadResponseTO;
import pl.lodomaniak.image.api.ImageUploadResponseTOBuilder;
import pl.lodomaniak.image.entity.ImageEntityBuilder;

import java.io.IOException;
import java.util.UUID;

@Service
public class DefaultImageService implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public DefaultImageService(final ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageUploadResponseTO store(final MultipartFile file) {
        final String name = UUID.randomUUID().toString() + ".jpg";

        try {
            imageRepository.save(new ImageEntityBuilder()
                    .withName(name)
                    .withImage(file.getBytes())
                    .build());
        } catch (IOException e) {
            throw new LodomaniakSystemException("Failed to save image", e);
        }

        return new ImageUploadResponseTOBuilder()
                .withName(name)
                .build();
    }

}
