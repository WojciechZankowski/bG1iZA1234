package pl.lodomaniak.image;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.lodomaniak.image.api.ImageUploadResponseTO;

@RestController
@RequestMapping("/api/image")
@Api(tags = "Image", description = "Endpoint to store images.")
public class ImageRestController {

    private final ImageService imageService;

    @Autowired
    public ImageRestController(final ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<?> handleFileUpload(@RequestParam final MultipartFile file) {
        final ImageUploadResponseTO response = imageService.store(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
