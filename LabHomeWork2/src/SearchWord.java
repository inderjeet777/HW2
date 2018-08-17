import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SearchWord{

	public static void main(String[] args) {
		
	

		BufferedReader br1=null,br2=null;
		try
		{
		br1=new BufferedReader(new FileReader("G:\\java lab home work\\HW2-master\\HW2-dictionary.txt"));//read dictionary file
		br2=new BufferedReader(new FileReader("G:\\java lab home work\\HW2-master\\HW2-keywords.txt"));//read keywords file
		BufferedWriter wr= null;
        File file = new File("G:\\java lab home work\\HW2-master\\words.txt");//write not found keywords in this file
        wr = new BufferedWriter(new FileWriter(file));
		String line=br1.readLine();
		String dict[]=new String [16000];
		String keywords[]=new String[84];
		int i=0;
		while(line!=null)
		{
			dict[i]=line;
			i++;
			line=br1.readLine();
		}
		
		sort(dict);
		line=br2.readLine();
		i=0;
		while(line!=null)
		{
			keywords[i]=line;
			i++;
			line=br2.readLine();
		}
		
		sort(keywords);
		int size=keywords.length,count=0;
		String output="";
		for(i=0;i<size;i++)
		{
			if(search_in_dict(keywords[i],dict)==0)
			{
				output="keyword not found: ";
				output+=keywords[i];
				output+='\n';
				wr.write(output);
				//System.out.println(keywords[i]);
				count++;
			}
		}
		output="number of keywords not found:=";
		output+=count;
		System.out.println(output);//for writing on console
		output="";
		wr.close();
		
		}
		catch (IOException ioe) 
	       {
		   ioe.printStackTrace();
	       } 
		finally
		{
			try
			{
				if(br1!=null)
				{
					br1.close();
				}
				if(br2!=null)
				{
					br2.close();
				}
				
					
				
			}
			
			   catch (IOException ioe) 
		           {
				   System.out.println("Error in closing the BufferedReader");
			   }
		}
	}
	static void sort(String str[])//insertion sort
	{
		int size=str.length;
		for(int i=1;i<size;i++)
		{
			int j=i-1;
			String s=str[i];
			while(j>-1&&(s.compareTo(str[j]))<0)
			{
				str[j+1]=str[j];
				j--;
			}
			str[j+1]=s;
		}
		
		
	}
	static int search_in_dict(String word,String dict[])//binary search
	{
		int low=0,high=dict.length-1,mid;
		
		while(low<=high)
		{
			mid=(low+(high-low)/2);
			int comp=word.compareTo(dict[mid]);
			if(comp==0)
				return 1;
			if(comp<0)
			{
				high=mid-1;
			}
			else
				low=mid+1;
		}
		return 0;
	}

}

