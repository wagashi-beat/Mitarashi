package mitarashi.DTO;

public class CategoryDTO {
	private String categoryId;
	private String categoryName;
	private String registDate;
	private String updateDate;

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getRegistDate(){
		return registDate;
	}

	public void setRegistDate(String registDate){
		this.registDate = registDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
