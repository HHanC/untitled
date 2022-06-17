package boardweb.dto;

import boardweb.domain.Board;
import lombok.*;

import javax.persistence.Entity;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BoardDto {

    private int bno;
    private String btitle;
    private String bcontent;
    private String bwrite;
    private String bpassword;

    // dto -> entity [ dto는 db에 들어갈수 없음~~~ ]
    public Board toentity(){
        return Board.builder()
                .bno( this.bno )
                .btitle( this.btitle)
                .bcontent( this.bcontent)
                .bpassword( this.bpassword)
                .bwrite( this.bwrite)
                .build();

    }

}
