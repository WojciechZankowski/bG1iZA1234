package pl.lodomaniak.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;
import pl.lodomaniak.core.exception.LodomaniakSystemException;
import pl.lodomaniak.image.entity.ImageEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Repository
public class ImageRepository {

    private final LodomaniakConfigurationProperties properties;

    @Autowired
    public ImageRepository(final LodomaniakConfigurationProperties properties) {
        this.properties = properties;
    }

    void save(final ImageEntity entity) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(createFilePath(properties.getImage().getPath(), entity.getName()));
            fos.write(entity.getImage());
        } catch (final IOException e) {
            throw new LodomaniakSystemException("Failed to save image.", e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // cry
                }
            }
        }
    }

    private String createFilePath(final String path, final String name) {
        return path + File.separator + name;
    }

}
