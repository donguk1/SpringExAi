package kopo.poly;

import kopo.poly.dto.StudentDTO;
import kopo.poly.service.IOcrService;
import kopo.poly.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class AiJavaPrjApplication implements CommandLineRunner {


//    @Service 정의된 자바 파일
//    Spring Frameworks 실행될 때, @Service 정의한 자바는 자동으로 메모리에 올림
//    메모리에 올라간 OcrService 객체를 ocrService 변수에 객체를 넣어주기
    private final IOcrService ocrService; //이미지 인식

    private final IStudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(AiJavaPrjApplication.class, args);

    }
    @Override
    public void run(String... args) throws Exception {
        log.info("자바 프로그래밍 시작!!");

//        String filePath = "image";
//        String fileName = "img/sample01.jpg";
//
//        OcrDTO pDTO = new OcrDTO();
//
//        pDTO.setFilePath(filePath);
//        pDTO.setFileName(fileName);
//
//        OcrDTO rDTO = ocrService.getReadforImageText(pDTO);
//
//        String result = rDTO.getResult();
//
//        log.info("인식된 문자열");
//        log.info(result);
//        log.info("자바 프로그래밍 종료!!");

        StudentDTO pDTO; //학생 응록, 수정, 삭제에 활용할 DTO
        List<StudentDTO> rList; // DB 조회 결과를 표현


//        insert
        pDTO = new StudentDTO();

        pDTO.setUserId("donguk0105");
        pDTO.setUserName("이동욱");
        pDTO.setEmail("donguk0105@naver.com");
        pDTO.setAddr("서울");

        rList = studentService.insertStudent(pDTO);

        rList.forEach(dto -> {
            log.info("DB에 저장된 아이티 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이베일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr());
        });


//        update
        pDTO = new StudentDTO();

        pDTO.setUserId("donguk0105");
        pDTO.setUserName("이동욱_수정");
        pDTO.setEmail("donguk0105@naver.com_수정");
        pDTO.setAddr("서울_수정");

        rList = studentService.updateStudent(pDTO);

        rList.forEach(dto -> {
            log.info("DB에 저장된 아이티 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이베일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr());
        });


//        delete
        pDTO = new StudentDTO();

        pDTO.setUserId(("donguk0105"));

        rList = studentService.deleteStudent(pDTO);

        rList.forEach(dto -> {
            log.info("DB에 저장된 아이티 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이베일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr());
        });


        //        다중 학생정보 넣기
        List<StudentDTO> pList = new ArrayList<>();

        for (int i = 1; i <= 3; i ++) {

            pDTO = new StudentDTO();
            pDTO.setUserId(i + "");
            pDTO.setUserName("이동욱");
            pDTO.setEmail("donguk0105@naver.com");
            pDTO.setAddr("서울");
            pList.add(pDTO);

        }

        log.info(pList + "");
        rList = studentService.insertStudentList(pList);

        rList.forEach(dto -> {
            log.info("DB에 저장된 ID : " + dto.getUserId());
            log.info("DB에 저장된 NAME : " + dto.getUserName());
            log.info("DB에 저장된 EMAIL : " + dto.getEmail());
            log.info("DB에 저장된 ADDR : " + dto.getAddr());
        });


        log.info(("자바 프로그래밍 종료!"));
    }







}
