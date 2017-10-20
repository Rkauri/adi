package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Show;
import com.util.DatabaseConnection;

public class ShowDaoImpl extends DatabaseConnection implements ShowDao  {

	public ShowDaoImpl(){
		if(conn==null){
			getStart();
			}
	}
	
	@Override
	public boolean addShow(Show showObj) {
		
		String querytoadd;
		boolean isSuccess=false;
		int var=0;
		try {
			querytoadd = "INSERT INTO `show`(`showName`, `duration`, `min_audio`, `min_video`, `min_adds`, `type`, `no_of_times_played`, `genre`) VALUES (?,?,?,?,?,?,?,?)";
			
				this.pstmt= this.conn.prepareStatement(querytoadd);
				pstmt.setString(1, showObj.getShowName());
				pstmt.setLong(2, showObj.getDuration());
				pstmt.setLong(3, showObj.getMin_audio());
				pstmt.setLong(4, showObj.getMin_video());
				pstmt.setLong(5, showObj.getMin_adds());
				pstmt.setLong(6, showObj.getMin_voice());
				pstmt.setInt(7, showObj.getType());
				pstmt.setString(8, showObj.getGenre());
				var=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		if(var==1){
			
		 isSuccess=true;
		}
		return isSuccess;
	}

	@Override
	public boolean editShow(Show showObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteShow(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Show> getAllShow() {
		List<Show> showlist= new ArrayList();
		try {	
		String queryToSelect="SELECT id,showName,duration,genre FROM `show`";
		pstmt=conn.prepareStatement(queryToSelect);
		reslt=pstmt.executeQuery();
		while(reslt.next()){
			Show showObj= new Show();
			showObj.setId(reslt.getInt(1));
			showObj.setShowName(reslt.getString(2));
			showObj.setDuration(reslt.getLong(3));
			showObj.setGenre(reslt.getString(4));
			showlist.add(showObj);
		}
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return showlist;
	}

	@Override
	public Show getShowById(int id) {
		// TODO Auto-generated method stub
		Show showObj= new Show();
		String queryToSelectShowById= "SELECT * FROM `show` WHERE id="+id;
		try {
			pstmt=conn.prepareStatement(queryToSelectShowById);
			System.out.println(queryToSelectShowById);
			reslt=pstmt.executeQuery();
			while(reslt.next()){
			showObj.setShowName(reslt.getString("showName"));
			showObj.setDuration(reslt.getLong("duration"));
			showObj.setGenre(reslt.getString("genre"));
			showObj.setType(reslt.getInt("type"));
			if(reslt.getInt("type")==1){
				showObj.setMin_audio(reslt.getLong("min_audio"));
			}else{
				showObj.setMin_video(reslt.getLong("min_video"));
			}
			showObj.setMin_adds(reslt.getLong("min_adds"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return showObj;
	}

}
