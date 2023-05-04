package example.junit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import application.Database;
import application.Project;
import application.WorkActivity;

public class DatabaseChecks {

	@org.junit.jupiter.api.Test // Junit 5
	public void isDatabaseSerializable() throws Exception {
		//Vi opretter et database objekt og giver det nogle værdier
		Database d = new Database();
		
		d.CreateEmployee("test");
		Project p = d.CreateProject(23069);
		p.addActivity(new WorkActivity("testAkt", p));
		
		
		//Vi tjekker om databasen kan serialiseres eller om der bliver kastet en exception
		try {
			new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(d);
			System.out.println("Databasen er serializable");
		} catch (IOException e) {
			System.out.println(e);
			System.out.println("Følgende klasse er ikke serializable: "+e.getMessage());
			org.junit.jupiter.api.Assertions.assertTrue(false);
		}
	}
}
