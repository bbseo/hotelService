package hotelServiceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class bookingLIstDTO {
	private int bookingNum;
	private int memberNum;
	private int roomNum;
	private String date;	
}
