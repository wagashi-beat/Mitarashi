package mitarashi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mitarashi.DTO.CategoryDTO;
import mitarashi.util.DBConnector;

public class CategoryDAO {

	private List<mitarashi.DTO.CategoryDTO>  categoryList = new ArrayList<CategoryDTO>();

	public List<CategoryDTO> getCategoryInfo(){
		mitarashi.util.DBConnector db = new DBConnector();

		Connection con = db.getConnection();
		String sql = "SELECT * FROM m_category";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				CategoryDTO dto = new CategoryDTO();
				dto.setCategoryId(rs.getString("category_id"));
				dto.setCategoryName(rs.getString("category_name"));
			    dto.setRegistDate(rs.getString("regist_date"));
				dto.setUpdateDate(rs.getString("update_date"));
				categoryList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categoryList;
	}
}
