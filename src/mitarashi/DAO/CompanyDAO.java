package mitarashi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mitarashi.DTO.CompanyDTO;
import mitarashi.util.DBConnector;

public class CompanyDAO {

	private List<mitarashi.DTO.CompanyDTO>  companyList = new ArrayList<CompanyDTO>();

	public List<CompanyDTO> getCompanyInfo(){
		mitarashi.util.DBConnector db = new DBConnector();

		Connection con = db.getConnection();
		String sql = "SELECT * FROM m_company";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				CompanyDTO dto = new CompanyDTO();
				dto.setCompanyId(rs.getString("company_id"));
				dto.setCompanyName(rs.getString("company_name"));
			    dto.setRegistDate(rs.getString("regist_date"));
				dto.setUpdateDate(rs.getString("update_date"));
				companyList.add(dto);
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
		return companyList;
	}
}
