package boardweb.controller;

import boardweb.dto.BoardDto;
import boardweb.service.Boardservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class Boardcontroller {
            // 1.   VIEW ----- SERVICE 제어
    @Autowired
    private Boardservice boardservice;

    ////////////////////////////////////////////////////////////// 화면 호출  컨트롤///////////////////////////////////////////
    @GetMapping("/")
    public String index(){ return "main";  }

    @GetMapping("/save")
    public String save(){ return "save"; }

    @GetMapping("/view")
    public String view(){ return  "view"; }

    @GetMapping("/updatpa")
    public String update(){ return  "update"; }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////// 기능처리 컨트롤///////////////////////////////////////////
    // 1. 여러 사람이 봤을때 가독성 !!
    // 2. Post( 기록x 보안높지만 )  vs get put delete( 기록o )

    @GetMapping("/getlist") //  호출
    public void getlist(HttpServletResponse response){
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(boardservice.getlist());
        }catch( Exception  e ){
            System.out.println( e );
        }
    }
    @GetMapping("/get") //  모든호출
    public void get(HttpServletResponse response , @RequestParam("bno") int bno ){
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(boardservice.get( bno ) );
        }catch( Exception  e ){
            System.out.println( e );
        }
    }
    @PostMapping("/save") // 저장
    @ResponseBody
    public Integer save(BoardDto boardDto){
        return boardservice.save( boardDto );
    }
    @PutMapping("/update") //  수정
    @ResponseBody
    public boolean update( BoardDto boardDto  ){
        return boardservice.update( boardDto );
    }
    @DeleteMapping("/delete")// 삭제
    @ResponseBody
    public boolean update( @RequestParam("bno") int bno  ){
        return boardservice.delete( bno );
    }
    ////////////////////////////////////////////////////////////// 기능처리 컨트롤 end ///////////////////////////////////////////


}
