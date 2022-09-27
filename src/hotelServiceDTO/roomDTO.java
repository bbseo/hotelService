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
	private int guestNum;
	private int maxGuestNum;
	private int price;
	private String category;
	
	public roomDTO(int hotelnum, String roomname, String img, int max_guest, int price, String category) {
		this.hotelnum=hotelnum;
		this.roomName=roomname;
		this.roomImage=img;
		this.maxGuestNum=max_guest;
		this.price=price;
		this.category=category;
	}

	public roomDTO(int roomnum, String roomName, String roomImage, int guestNum, int maxGuestNum, int price, String category) {
		this.roomNum=roomnum;
		this.roomName=roomName;
		this.roomImage=roomImage;
		this.guestNum=guestNum;
		this.maxGuestNum=maxGuestNum;
		this.price=price;
		this.category=category;
	}
}
