package csatdisplay;

public class CsatQuest {

	
	private String pname;
	private String sPName;
	private String CPName;
	private String cmt;
	private int rating;
    private String questions;
	private char qType;
	private String qno;
	private String role;
	
	public void setProjectName(String pname)
	{
		this.pname=pname;
	}
	public void setProjectManager(String sPName)
	{
		this.sPName=sPName;
	}
	public void setCustomerManager(String CPName)
	{
		this.CPName=CPName;
	}
	
	public void setRating(int arr)
	{
		rating=arr;
	}
	public void setComment(String cmt1)
	{
		cmt=cmt1;
	}

	public void setQuestions(String arr1)
	{
		questions=arr1;
	}
	public void setQuestionNo(String arr)
	{
		qno=arr;
	}
	
	public void setQuestionType(char qType)
	{
		this.qType=qType;
	}
	
	public void setRole(String role)
	{
		this.role=role;
	}
	
	public String getProjectName()
	{
		return pname;
	}
	
	
	
	public String getProjectManager()
	{
		return sPName;
	}
	public String getCustomerManager()
	{
		return CPName;
	}
	
	public int getRating()
	{
		return rating;
	}
	
	public String getComment()
	{
		return cmt;
	}
	public String getQuestions()
	{
		return questions;
	}
	public String getQuestionNos()
	{
		return qno;
	}
	
	public char getQuestionType()
	{
		return qType;
	}
	public String getRole()
	{
		return role;
	}
	
	
}
