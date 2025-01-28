package kr.kdev.demo.file;

import org.apache.commons.io.FilenameUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/file")
class FileApi {
    @PostMapping("/upload")
    fun post(@RequestPart("file") file: MultipartFile): ResponseEntity<String> {
        if (file.isEmpty) {
            throw IllegalArgumentException("File is empty");
        }
        FilenameUtils.getExtension(file.originalFilename).toRegex()
            .find("^(jpg|jpeg|png|gif)$") ?: throw IllegalArgumentException("File extension is not allowed");
        return ResponseEntity.ok(file.originalFilename);
    }
}
