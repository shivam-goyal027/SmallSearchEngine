public class Position
{
	private PageEntry p1;
	private int w;
	Position(PageEntry p, int wordIndex)
	{
		p1=p;
		w=wordIndex;	
	}
	PageEntry getPageEntry()
	{
		 return p1;
	}
	int getWordIndex()
	{
		 return w;
	}
}