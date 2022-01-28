package com.cos.Link.web;

import com.cos.Link.domain.Book;
import com.cos.Link.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    // security (라이브러리 적용) - CORS 정책을 가지고 있다.
    // 시큐리티가 CORS를 해제해야 한다.
    // BookController 진입 직전
    @PostMapping("/api/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.저장하기(book) , HttpStatus.CREATED);
    }
    
    //ResponseEntity
    @GetMapping("/api/book")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(bookService.모두가져오기() , HttpStatus.OK);
    }

    @GetMapping("/api/book/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.한건가져오기(id) , HttpStatus.OK);
    }


    @PutMapping("/api/book/{id}")
    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody Book book) {
        return new ResponseEntity<>(bookService.수정하기(id, book) , HttpStatus.OK);
    }


    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.삭제하기(id) , HttpStatus.OK);
    }


}
