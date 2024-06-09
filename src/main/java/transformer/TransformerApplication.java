package transformer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import transformer.parsers.impl.TransformerGroupThree;

@SpringBootApplication
public class TransformerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransformerApplication.class, args);

	TransformerGroupThree transformerGroupThree = new TransformerGroupThree();
//	Pair p = transformerGroupThree.operation("Да ли си μι ΔΡΑΓΑΝ 42ρ42 ΚΒΙΓΙΟ");
//
//		System.out.println("Да ли си μι ΔΡΑΓΑΝ 42ρ42 ΚΒΙΓΙΟ");
//	System.out.println(p);
	}

}
