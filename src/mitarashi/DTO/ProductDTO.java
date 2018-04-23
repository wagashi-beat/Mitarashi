package mitarashi.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mitarashi.DAO.CategoryDAO;
import mitarashi.DAO.CompanyDAO;

public class ProductDTO {
	
	private int id;
	private int productId;
	private int price;
	private int categoryId;
	private int companyId;
	private int stockCount;
	private int status;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private String imageFilePath;
	private String imageFileName;
	private String releasedate;
	private Date registDate;
	private Date updateDate;
	
	//カテゴリ名をひっぱってくるやつ
	private String categoryName;
	
	public String getCategoryName(){
		return categoryName;
	}
	public void setCategoryName(String categoryName){
		this.categoryName=categoryName;
	}
	public void setCategoryName(Integer category_id){
		List<CategoryDTO> categoryList=new ArrayList<>();
		CategoryDAO categoryDAO=new CategoryDAO();
		categoryList=categoryDAO.getCategoryInfo();
		
		for(int i=0;i < categoryList.size(); i++ ){
			if(categoryList.get(i).getCategoryId().equals(category_id.toString())){
				this.categoryName=categoryList.get(i).getCategoryName();
			}
		}
	}
	
	//販売会社名をひっぱってくるやつ
	private String companyName;
	
	public String getCompanyName(){
		return companyName;
	}
	public void setCompanyName(String companyName){
		this.companyName=companyName;
	}
	public void setcompanyName(Integer release_company_id){
		List<CompanyDTO> companyList=new ArrayList<>();
		CompanyDAO companyDAO=new CompanyDAO();
		companyList=companyDAO.getCompanyInfo();
		
		for(int i=0;i < companyList.size(); i++ ){
			if(companyList.get(i).getCompanyId().equals(release_company_id.toString())){
				this.companyName=companyList.get(i).getCompanyName();
			}
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	

}
