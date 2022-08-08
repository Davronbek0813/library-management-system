package uz.pdp.librarymanagementsystem.issuedReturnedBooks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class IssuedReturnedBooks {


    private  Integer id ;
    private  Integer userId ;
    private  Integer bookId ;
    private Date date;
    private  boolean issued;

}
