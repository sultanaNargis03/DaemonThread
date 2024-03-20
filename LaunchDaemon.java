package practice;

class Notepad implements Runnable
{
	public void run()
	{
		String tName=Thread.currentThread().getName();
		if(tName.equals("TYPE"))
		{
			typing();
		}
		else if(tName.equals("SPELLCHECK"))
		{
			spellCheck();
		}
		else
		{
			autoSave();
		}
	}
	void typing()
	{
		for(int i=0;i<3;i++)
		{	
			System.out.println("typing:Focus is the key");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	void spellCheck()
	{
		for(;;)
		{
			System.out.println("spell checking........");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	void autoSave()
	{
		for(;;)
		{
			System.out.println("auto-saving.....");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class LaunchDaemon 
{
	public static void main(String[] args)
	{
		Notepad np=new Notepad();
		
		Thread t1=new Thread(np);
		Thread t2=new Thread(np);
		Thread t3=new Thread(np);
		
		t1.setName("TYPE");
		t2.setName("SPELLCHECK");
		t3.setName("SAVE");
		
		t2.setDaemon(true);
		t3.setDaemon(true);
		
		t2.setPriority(3);
		t3.setPriority(3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
