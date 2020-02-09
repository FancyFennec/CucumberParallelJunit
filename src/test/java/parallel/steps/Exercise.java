package parallel.steps;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "exercise")
public class Exercise {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "question")
	private String question;
	
	public Exercise() {}
}
