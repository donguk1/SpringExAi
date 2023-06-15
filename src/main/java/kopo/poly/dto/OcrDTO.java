package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class OcrDTO {
    private String filePath;
//    저장된 이미지 파일의 파일 저장 경로
    private String fileName;
//    저장된 이미지 파일 이름
    private String result;
//    저장된 이미지로부터 읽은 글씨

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

