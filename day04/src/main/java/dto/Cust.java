package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Cust {
    private String id;
    private String pwd;
    private String name;

}
