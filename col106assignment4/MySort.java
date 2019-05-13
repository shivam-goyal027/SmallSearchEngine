import java.util.*;
public class MySort
{
	ArrayList<SearchResult> sortThisList(Myset<SearchResult> listOfSortableEntries)
	{
		ArrayList<SearchResult> als=new ArrayList<>();
		int length=listOfSortableEntries.l1.size();
		for(int i=0;i<length;i++)
		{
			als.add(listOfSortableEntries.l1.get(i));
		}
		Collections.sort(als);
		return als;
	}
}