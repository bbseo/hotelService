package hotelServiceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class roomDTO {
	private int roomNum;
	private int hotelnum;
	private String roomName;
	private String roomImage;
	private String roomState;
	private int gurestNum;
	private int maxGuestNum;
	private int price;
	private String category;
	
}
