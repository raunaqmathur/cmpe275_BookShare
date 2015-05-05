package edu.sjsu.cmpe275.prj.models;



import org.springframework.web.multipart.MultipartFile;
 
public class BookImageUpload {
 
    private MultipartFile bookImageFile;
 
    public MultipartFile getFile() {
        return bookImageFile;
    }
 
    public void setFiles(MultipartFile file) {
        this.bookImageFile = file;
    }
}
