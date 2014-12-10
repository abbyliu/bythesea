package leecode.clonegraph;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Test {
	
	final private static ThreadLocal<DatatypeFactory> datatypeFactoryHolder = new ThreadLocal<DatatypeFactory>()
		    {
		        @Override
		        protected DatatypeFactory initialValue()
		        {
		            try
		            {
		                return DatatypeFactory.newInstance();
		            } catch (DatatypeConfigurationException e)
		            {
		                throw new IllegalStateException("failed to create " + DatatypeFactory.class.getSimpleName(), e);
		            }
		        }
		    };

	public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date)
	{
	    GregorianCalendar c = new GregorianCalendar();
	    c.setTime(date);
	    return datatypeFactoryHolder.get().newXMLGregorianCalendar(c);
	}

public static void main(String[] args) throws DatatypeConfigurationException {

	List<Integer> list = new ArrayList<>();
	for (int i = 0; i < 100; i++) {
		list.add(null);
	}
		long start = System.currentTimeMillis();
	for (int i = 0; i < 600000; i++) {
		Random rd = new Random();
		Date dt = new Date(rd.nextLong());
		Test.dateToXMLGregorianCalendar(dt);
	}
		long end = System.currentTimeMillis();
		System.out.println("takes " + (end-start)/1000 + " seconds");
	}
}
