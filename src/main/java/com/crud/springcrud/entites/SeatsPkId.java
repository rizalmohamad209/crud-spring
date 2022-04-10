package com.crud.springcrud.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@AllArgsConstructor
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter



public class SeatsPkId  implements Serializable {
    private Studio studio;
    private Integer seats_number;
}
