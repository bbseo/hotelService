package hotelServiceDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class memberDTO {
	private int memberNum;
	private String id;
	private String pw;
	private String memberName;
	private String tel;
	private String email;
	private int memberGrade;
	private String authority;
	
	public memberDTO(String name, String id, String pw, String tel, String email) {
		this.memberName = name;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.email = email;
	}
	
}
