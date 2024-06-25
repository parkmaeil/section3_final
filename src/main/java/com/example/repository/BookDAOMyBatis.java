package com.example.repository;

import com.example.entity.BookDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookDAOMyBatis { // 리팩토링 => 중앙집중식 관리, 코드의 간결성, 자원의관리의 효율성

        public List<BookDTO> bookList(){
            try(SqlSession session=MyBatisUtil.openSession()){ // close()
                 return session.selectList("bookList");
            }
        // try 블록이 종료되면 session은 자동으로 close 됩니다.
       }
       // 삭제기능
       public int bookDelete(int reqNum){
            try(SqlSession session=MyBatisUtil.openSession()){
                 int cnt=session.delete("bookDelete", reqNum); // int -> Integer : Boxing(박싱)
                 session.commit();// 완료
                 return cnt;
            }
       }
       // 등록기능   : bookRegister(BookDTO dto)
       public int bookRegister(BookDTO dto){
           try(SqlSession session=MyBatisUtil.openSession()){ // close()
               int cnt=session.insert("bookRegister", dto);
               session.commit();// 완료
               return cnt;
           }
       }
      //  상세보기
    public BookDTO bootDetail(int reqNum){
            try(SqlSession session=MyBatisUtil.openSession()){ // close()
                // BookDTO dto=session.selectOne("bootDetail",reqNum); // BookDTO
                return session.selectOne("bootDetail",reqNum); // SqlSession->bootDetail->Mapper.xml
            }
    }
    // 수정하기 : 수정할 데이터(num , DTO)
    public int bookUpdate(int reqNum, BookDTO dto){
        try(SqlSession session=MyBatisUtil.openSession()){ // close()
            dto.setNum(reqNum); // ?
            // Map<Key, Value>
            int cnt=session.update("bookUpdate", dto);
            session.commit();// 완료
            return cnt;
        }
    }

}
