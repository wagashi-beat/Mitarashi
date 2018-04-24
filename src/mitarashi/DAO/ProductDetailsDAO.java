package mitarashi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mitarashi.DTO.ProductDTO;
import mitarashi.util.DBConnector;

public class ProductDetailsDAO {
	DBConnector dbConnector=new DBConnector();
	Connection connection=dbConnector.getConnection();
	ProductDTO productDTO=new ProductDTO();

	//商品IDに対応する商品詳細情報取得
	public ArrayList<ProductDTO> getProductDetailsInfo(String productId) throws SQLException{
		ArrayList<ProductDTO> productDTOList=new ArrayList<ProductDTO>();

		String sql="SELECT * FROM product_info where product_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				productDTO.setId(resultSet.getInt("id"));
				productDTO.setProductId(resultSet.getInt("product_id"));
				productDTO.setProductName(resultSet.getString("product_name"));
				productDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productDTO.setProductDescription(resultSet.getString("product_description"));
				productDTO.setPrice(resultSet.getInt("price"));
				productDTO.setStockCount(resultSet.getInt("stock_count"));
				productDTO.setReleaseDate(resultSet.getString("release_date"));
				productDTO.setCategoryId(resultSet.getInt("category_id"));
				productDTO.setCompanyId(resultSet.getInt("company_id"));
				productDTO.setStockCount(resultSet.getInt("stock_count"));
				productDTOList.add(productDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return productDTOList;
	}
	
	//おすすめ商品リスト
	public ArrayList<ProductDTO> getSuggestProductInfo(int category_id) throws SQLException{
		
	}

}
