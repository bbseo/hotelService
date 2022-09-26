package hotelServiceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class hotelDTO {
	private int hotelNum;
	private String hotelName;
	private String hotelImagePath;
	private double star;
	private String hotelLocation;
	private int hotelGrade;
	
}
