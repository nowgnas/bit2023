package dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Item {
    private int id;
    private String name;
    private long price;
    private Date regdate;
}
