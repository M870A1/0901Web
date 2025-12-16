package org.zerock.yesyes2.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date; // java.sql.Date 임포트

@Getter
@ToString
@AllArgsConstructor
@Builder

// VO : DB에서 데이터를 꺼낼때 사용하는 객체
// 데이터를 꺼내는 용도로 사용하기 때문에 Setter를 구현하지 않음
// 테이블의 열과 변수가 1대1로 매칭되록 작성

public class BoardVO {
    private int num;
    private String title;
    private String content;
    private String author; // 작성자 이름
    private String id;     // 작성자 아이디
    private Date postdate;
    private int visitcount;
}
