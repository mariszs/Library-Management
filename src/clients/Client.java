package clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private int clientId; //? Long, int ?
    private String clientName;
    private String email;
    private int phone;
    private int minusPoints;
    private boolean isBlocked; // ? boolean?
    private int booksBorrowed;


}



