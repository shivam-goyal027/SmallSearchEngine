import java.lang.*;
public class SearchResult implements Comparable<SearchResult>
{
	PageEntry pesr;
	float rele;
	public SearchResult(PageEntry p, float r)
	{
		pesr=p;
		rele=r;
	}
	public PageEntry getPageEntry(){
		return pesr; 
	}
	public float getRelevance(){
		return rele;
	}
	public int compareTo(SearchResult otherObject)
	{
		if(this.getRelevance()>otherObject.getRelevance())
			return 1;
		else if(this.getRelevance()<otherObject.getRelevance())
			return -1;
		else
			return 0;
	}
}