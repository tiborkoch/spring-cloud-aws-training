package cloud.training.aws.blob.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cloud.training.aws.blob.config.ApplicationConfiguration;
import cloud.training.aws.blob.service.IProductService;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Operations;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    private final ApplicationConfiguration configuration;
    private final S3Operations s3Operations;

    @GetMapping
    public ResponseEntity<List<ProductData>> getProducts() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductData> createProduct(@RequestBody CreateProductRequest request) {
        ProductData savedProduct = productService.save(request);
        return ResponseEntity.ok(savedProduct);
    }

    @PostMapping(value = "/{id}/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> upload(@PathVariable("id") Integer productId, @RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            s3Operations.upload(configuration.getBucketName(), productId + "-" + multipartFile.getOriginalFilename(), inputStream,
                    ObjectMetadata.builder().contentType(multipartFile.getContentType()).build());
        }
        return ResponseEntity.accepted().build();
    }
}
