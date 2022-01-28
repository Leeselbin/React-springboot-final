package com.cos.Link.service;

import com.cos.Link.domain.Book;
import com.cos.Link.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 기능을 정의할 수 있고, 트랜잭션을 관리할 수 있음.

@RequiredArgsConstructor //final 선언된애들 자동으로 DI해줌
@Service
public class BookService {


    private final BookRepository bookRepository;

    @Transactional //실패하면 롤백된다. 서비스 함수가 종료될때 commit할지 rollback할지
    public Book 저장하기(Book book) {
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)  // JPA 변경감지라는 내부 기능 활성화X 트래픽줄여줌
    public Book 한건가져오기(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요"));
    }

    @Transactional(readOnly = true)
    public List<Book> 모두가져오기() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book 수정하기(Long id, Book book) {
        // 더티체킹 update치기
        Book bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요"));

        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        return bookEntity;
    } // 함수 종료 => 트랜잭션 종료 => 영속화 되어있는 데이터를 갱신(flush)

    @Transactional
    public String 삭제하기(Long id){
        bookRepository.deleteById(id);
        return "ok";
    }
}
