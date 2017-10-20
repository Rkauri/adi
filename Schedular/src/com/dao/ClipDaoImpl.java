package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Clip;
import com.util.DatabaseConnection;

public class ClipDaoImpl extends DatabaseConnection implements ClipDao {

	public ClipDaoImpl(){
		if(conn==null){
		getStart();
		}
	}
	@Override
	public boolean addClip(Clip clipObj) {
		boolean isSuccess=false;
		try {
			String queryToAddClip="INSERT INTO `clip`(`filename`, `file_duration`, `file_type`, `check_adds`, `no_of_times_played`, `max`, `min`, `genre`) VALUES (?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(queryToAddClip);
			pstmt.setString(1, clipObj.getFilename());
			pstmt.setLong(2, clipObj.getFile_duration());
			pstmt.setInt(3, clipObj.getFile_type());
			pstmt.setBoolean(4, clipObj.isCheck_ads());
			pstmt.setInt(5,clipObj.getNo_of_times_played());
			pstmt.setInt(6, clipObj.getMax());
			pstmt.setInt(7, clipObj.getMin());
			pstmt.setString(8, clipObj.getGenre());
			int i=pstmt.executeUpdate();
			if(i==1){
				isSuccess=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return isSuccess;
	}

	@Override
	public boolean editClip(Clip clipObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClip(int clipid) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Clip> getClipByLength(Long duration, int type, String genre) {
		List<Clip> cliplist= new ArrayList<>();
		try {
			String queryToGetClip="SELECT `filename`, `file_duration` FROM `clip` WHERE  file_duration="+duration+" and file_type="+type+" and genre='"+genre+"'";
			pstmt=conn.prepareStatement(queryToGetClip);
			reslt=pstmt.executeQuery();
			while(reslt.next()){
				Clip clipObj= new Clip();
				clipObj.setFilename(reslt.getString(1));
				clipObj.setFile_duration(reslt.getLong(2));
				cliplist.add(clipObj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
		return cliplist;
	}

}
