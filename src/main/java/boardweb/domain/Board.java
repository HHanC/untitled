package boardweb.domain;


import lombok.*;

import javax.persistence.*;

 //@Entity  앤티티는  db 테이블과 매핑된 개체 [ 그래서 dto 가 아닌 엔티티를 조작하면 db도 조작된다  ]
@Table (name = "board2")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwrite;
    private String bpassword;


}
