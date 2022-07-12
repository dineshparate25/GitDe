package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamDemo
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<String> names=new ArrayList<>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Antham");
		names.add("Antham");
		names.add("Antham");
		int count=0;
		
		for(int i=0;i<names.size();i++)
		{
			String actual=names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
		streamFilter();

	}
	public static void streamFilter()
	{
		ArrayList<String> names=new ArrayList<>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Antham");
		names.add("Antham");
		names.add("Antham");
		Long count;
		count=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);
		
		//map function iterate and perform string operation on string
		Stream.of("Abhijeet","Dinesh","Alexa","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		List<String> names1=Arrays.asList("D","Ru","te");
		
		names1.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging two string
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Alexa"));
		System.out.println(flag);
		//Assert.assertTrue(flag);
		
		
	}
	

}
