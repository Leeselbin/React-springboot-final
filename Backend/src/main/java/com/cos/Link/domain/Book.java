package com.cos.Link.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //서버 실행시에 테이블이 DB에 생성된다.
public class Book {

    @Id  //PK를 해당 변수로 하겠다는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY) //해당 데이터베이스 번호증가 전략을 따라가겠다.
    private Long id;

    private String title;
    private String author;


}
