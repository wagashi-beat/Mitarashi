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
	
	//購入個数リスト
	private List<Integer> stockList=new ArrayList<Integer>();
	
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
    			session.put("imageFilePathD", productDTO.getImageFilePath());
    			session.put("productNameD", productDTO.getProductName());
    			session.put("productNameKanaD", productDTO.getProductNameKana());
    			session.put("productDescriptionD", productDTO.getProductDescription());
    			session.put("productPriceD", productDTO.getPrice());
    			session.put("", value)
    		}
    	}
    	
    	
    }

	


}
