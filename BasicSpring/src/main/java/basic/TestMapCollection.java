package basic;

import java.util.Map;
import java.util.Map.Entry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMapCollection 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("configure.xml");
		Bank bank = (Bank) context.getBean("bank");
		System.out.println("Bank Name :" + bank.getName());
//		System.out.println("Bank Accounts :" + bank.getAccounts());
		Map<String, Account> map=bank.getAccounts();
		for(Entry<String, Account> entry:map.entrySet())
		{
			System.out.println(entry.getKey()+"    "+entry.getValue());
		}
		((AbstractApplicationContext)context).registerShutdownHook();
		((AbstractApplicationContext)context).close();
//		Bank bank2=(Bank)context.getBean("bank");
	}
}