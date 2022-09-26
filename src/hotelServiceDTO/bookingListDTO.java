package hotelServiceDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class bookingListDTO {
	private int bookingNum;
	private int memberNum;
	private int roomNum;
	private Date checkin_date;
	private Date checkout_date;
	private Date booked_date;
	private Date booked_cancel_date;
	private String memberName;
	
	public bookingListDTO(int bookingNum, String membername, int roomNum, String checkin_date2, String checkout_Num,String booked_date2, String booked_cancel_date2) {
		this.bookingNum = bookingNum;
	
	}	

}
