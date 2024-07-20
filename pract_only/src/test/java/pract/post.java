package pract;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;

public class post {

	public static void main(String[] args) throws FileNotFoundException
	{
		
	File f=new File("../pract_only/anything.json"); 
	java.io.FileReader fr=new java.io.FileReader(f);
	JSONTokener js=new JSONTokener(fr);////In Java, passing an object from one class to the constructor of another class allows the second class to 
    //use the data or methods provided by the first class. This is a common pattern used to initialize objects that depend on other objects.
	
	JSONObject j=new JSONObject(js);
	Response res=
		given()
		.contentType(ContentType.JSON)
		.body(j.toString())////j is a variable that holds some data, typically a JSON object and .toString() converts the data held by j to a string representation.
		.when()
		.post("http://localhost:3000/APIStudents");
	System.out.println("status code is ");
	System.out.println(res.statusCode());
	System.out.println("response data is ");
	System.out.println(res.asString());
	
	}
}	
