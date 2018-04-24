package mitarashi.Action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import mitarashi.DAO.ProductDetailsDAO;
import mitarashi.DTO.CategoryDTO;
import mitarashi.DTO.CompanyDTO;
import mitarashi.DTO.ProductDTO;
public class ProductDetailsAction extends ActionSupport implements SessionAware {

	public Map<String,Object> session;

	private int id;
	private int productId;
	private int categoryId;
	private int companyId;
	private int price;
	private int stockCount;

	private String error;
	private int insertFlg;

	//購入個数リスト
	private List<Integer> countList=new ArrayList<Integer>();

	//商品詳細情報リスト
	public ArrayList<ProductDTO> productDTOList=new ArrayList<ProductDTO>();
	public ProductDTO productDTO=new ProductDTO();

	//おすすめ商品リスト
	public List<ProductDTO> suggestList=new ArrayList<ProductDTO>();


	public ProductDetailsDAO productDetailsDAO=new ProductDetailsDAO();

    //カテゴリ、販売会社のリスト
    public ArrayList<CompanyDTO> companyList;
    public ArrayList<CategoryDTO> categoryList;

    public String execute() throws SQLException{

    	try{
    		productDTOList=productDetailsDAO.getProductDetailsInfo(productId);

    		if(productDTO !=null){
    			session.put("productIdD", productDTO.getProductId());
    			session.put("imageFilePathD", productDTO.getImageFilePath());
    			session.put("productNameD", productDTO.getProductName());
    			session.put("productNameKanaD", productDTO.getProductNameKana());
    			session.put("productDescriptionD", productDTO.getProductDescription());
    			session.put("productPriceD", productDTO.getPrice());
    			session.put("releaseDateD", productDTO.getReleaseDate());
    			session.put("companyIdD", productDTO.getCompanyId());
    			session.put("categoryIdD", productDTO.getCategoryId());
    			session.put("stockCountD", productDTO.getStockCount());
    		}else{
    			String result=ERROR;
    			return result;
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}

    	//おすすめ商品取得＠まだ！
    	try{

    	}catch(Exception e){
    		e.printStackTrace();
    	}

    	//1から在庫数までの選択表示
    	for(int i=1; i<=productDTO.getStockCount(); i++){
    		countList.add(i);
    	}

    	price = productDTO.getPrice();

		String result = SUCCESS;
		return result;

    }

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getInsertFlg() {
		return insertFlg;
	}

	public void setInsertFlg(int insertFlg) {
		this.insertFlg = insertFlg;
	}

	public List<Integer> getCountList() {
		return countList;
	}

	public void setCountList(List<Integer> countList) {
		this.countList = countList;
	}

	public ArrayList<ProductDTO> getProductDTOList() {
		return productDTOList;
	}

	public void setProductDTOList(ArrayList<ProductDTO> productDTOList) {
		this.productDTOList = productDTOList;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public List<ProductDTO> getSuggestList() {
		return suggestList;
	}

	public void setSuggestList(List<ProductDTO> suggestList) {
		this.suggestList = suggestList;
	}

	public ProductDetailsDAO getProductDetailsDAO() {
		return productDetailsDAO;
	}

	public void setProductDetailsDAO(ProductDetailsDAO productDetailsDAO) {
		this.productDetailsDAO = productDetailsDAO;
	}

	public ArrayList<CompanyDTO> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(ArrayList<CompanyDTO> companyList) {
		this.companyList = companyList;
	}

	public ArrayList<CategoryDTO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}




}
