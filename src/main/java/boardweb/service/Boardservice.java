package boardweb.service;

import boardweb.domain.Board;
import boardweb.domain.BoardRepository;
import boardweb.dto.BoardDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Boardservice {
            // 1. 로직 , 2.트랜잭션[DB조작]

    @Autowired
    private BoardRepository boardRepository;

    // 1. 쓰기 [ 인수 : BoardDto ]
    @Transactional
    public Integer save(BoardDto boardDto){
        return boardRepository.save( boardDto.toentity() ).getBno() ;
    }
    // 2. 모든 게시물 출력  [ 인수 : x ]
    public JSONArray getlist(){
        List<Board> boards = boardRepository.findAll();
        // 반환 선택 : 1. json 2.map
        JSONArray jsonArray = new JSONArray();

            // 엔티티 리스트 -> json 리스트 변환 생략

        return jsonArray;
    }
    // 3. 개별 게시물 출력 [ 인수 : 게시물번호 ]
    public JSONObject get( int bno ){
        Optional<Board> OpBoard =  boardRepository.findById( bno );
        Board board =   OpBoard.get();
        // 반환 선택 :  1. json 2. Map
        JSONObject object = new JSONObject();

            // 엔티티 객체 -> json 객체 변환 생략

        return object;
    }
    // 4. 수정 [ 인수 : 게시물번호 , 수정할 정보 ]
    @Transactional
    public boolean update( BoardDto boardDto ){
        Optional<Board> OpBoard =  boardRepository.findById( boardDto.getBno() );
        Board board =   OpBoard.get();
        board.setBcontent( boardDto.getBcontent() );
        board.setBtitle( boardDto.getBtitle() );
        return  true;
    }
    // 5. 삭제 [ 인수 : 게시물번호 ]
    @Transactional
    public boolean delete( int bno ){
         Optional<Board> OpBoard =  boardRepository.findById( bno );
         Board board =   OpBoard.get();
         boardRepository.delete(  board    );
    }





}
