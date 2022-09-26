package hotelServiceDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class memberDTO {
	private int memberNum;
	private String id;
	private String pw;
	private String memberName;
	private String tel;
	private String email;
	private String memberGrade;
	private String position;

	public memberDTO(String name, String id, String pw, String tel, String email) {
		this.memberName = name;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.email = email;
	}
	
	public static memberDTO getContent(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
