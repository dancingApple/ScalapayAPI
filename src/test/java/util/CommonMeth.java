package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonMeth {
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{

		if(req==null)
		{
			req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
					.addHeader("Authorization", "Bearer "+getGlobalValue("secretApi"))
					.setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream("src/test/java/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
}
