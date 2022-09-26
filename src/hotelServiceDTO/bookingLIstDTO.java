package hotelServiceDTO;

import java.sql.Date;

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
	private Date checkin_date;
	private Date checkout_date;
	private Date booked_date;
	private Date booked_cancel_date;
	
}
