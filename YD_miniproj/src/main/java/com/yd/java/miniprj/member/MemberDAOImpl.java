package com.yd.java.miniprj.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yd.java.miniprj.common.DAO;

public class MemberDAOImpl implements MemberDAO {
   private Connection con = DAO.getInstance();
   private PreparedStatement psmt;
   private ResultSet rs;
   
   @Override
   public List<MemberVO> memberSelectAll() {
	   // 전체리스트 가져오기
	   List<MemberVO> members = new ArrayList<MemberVO>();
	   MemberVO vo;
	   String sql = "SELECT * FROM MEMBERS";
	   try {
		   psmt = con.prepareStatement(sql);
		   rs = psmt.executeQuery();
		   while (rs.next()) {
			   vo = new MemberVO();
			   vo.setMemberID(rs.getString("member_id"));
			   vo.setMemberName(rs.getString("member_name"));
			   vo.setMemberPassword(rs.getString("member_password"));
			   vo.setMemberTel(rs.getString("member_tel"));
			   vo.setMemberAddress(rs.getString("member_address"));
			   vo.setMemberEmail(rs.getString("member_email"));
			   members.add(vo);
			   
           	}
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   close();
	   }
	   return members;
   }
   
   @Override
   public MemberVO memberSelectOne(MemberVO mem) {
	   // 한명분 조회
	   String sql = "SELECT * FROM MEMBERS WHERE MEMBER_ID = ?";
	   try {
		   psmt = con.prepareStatement(sql);
		   psmt.setString(1, mem.getMemberID());
		   rs = psmt.executeQuery();
		   if (rs.next()) {
			   mem.setMemberID(rs.getString("member_id"));
			   mem.setMemberName(rs.getString("member_name"));
			   mem.setMemberPassword(rs.getString("member_password"));
			   mem.setMemberTel(rs.getString("member_tel"));
			   mem.setMemberAddress(rs.getString("member_address"));
			   mem.setMemberEmail(rs.getString("member_email"));
            }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   close();
	   }
	   return mem;
   }

   @Override
   public int memberInsert(MemberVO mem) {
	   // 멤버추가
	   String sql = "INSERT INTO MEMBERS VALUES(?,?,?,?,?,?)";
	   int n = 0;
	   try {
		   psmt = con.prepareStatement(sql);
		   psmt.setString(1, mem.getMemberID());
		   psmt.setString(2, mem.getMemberName());
		   psmt.setString(3, mem.getMemberPassword());
		   psmt.setString(4, mem.getMemberTel());
		   psmt.setString(5, mem.getMemberAddress());
		   psmt.setString(6, mem.getMemberEmail());
		   n = psmt.executeUpdate();
		   
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   close();
	   }
	   return n;
   }

   @Override
   public int memberUpdate(MemberVO mem) {
	   // 멤버 수정
	   String sql = "UPDATE MEMBERS SET MEMBER_PASSWORD = NVL(?,MEMBER_PASSWORD), MEMBER_TEL = NVL(?, MEMBER_TEL), "
			   + "MEMBER_ADDRESS = NVL(?, MEMBER_ADDRESS), MEMBER_EMAIL = NVL(?, MEMBER_EMAIL)" + "WHERE MEMBER_ID = ?";
       int n = 0;
       try 	{
    	   psmt = con.prepareStatement(sql);
    	   psmt.setString(1, mem.getMemberPassword());
    	   psmt.setString(2, mem.getMemberTel());
    	   psmt.setString(3, mem.getMemberAddress());
    	   psmt.setString(4, mem.getMemberEmail());
    	   n = psmt.executeUpdate();
       } catch (SQLException e) {
    	   e.printStackTrace();
       } finally {
    	   close();
       }
       return n;
   }

   @Override
   public int memberDelete(String memID) {
	   // 멤버 삭제
	   String sql = "DELETE FROM MEMBERS WHERE MEMBER_ID = ?";
	   MemberVO mem = new MemberVO();
	   int n = 0;
	   try {
		   psmt = con.prepareStatement(sql);
		   psmt.setString(1, mem.getMemberID());
		   n = psmt.executeUpdate();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   close();
	   }
	   return n;
   }

   @Override
   public boolean isIdCheck(String id) {
      // 아이디 중복 체크
      String sql = "SELECT COUNT(MEMER_ID) AS MEMBER_ID FROM MEMBERS WHERE MEMBER_ID = ?";
      boolean b = false;
      try {
      	psmt = con.prepareStatement(sql);
        psmt.setString(1, id);
        rs = psmt.executeQuery();
        if (rs.next()) {
        	if (rs.getInt("ID") == 0) {
        		b = true;
        	} else {
        		b = false;
        	}
        }
      } catch (SQLException e) {
    	  e.printStackTrace();
      } finally {
    	  close();
      }
      return b;
   }

   @Override
   public MemberVO memberLogin(MemberVO vo) {
	   // 로그인
	   String sql = "SELECT * FROM MEMBERS WHERE MEMBER_ID = ? AND MEMBER_PASSWORD = ?";
	   try {
		   psmt = con.prepareStatement(sql);
		   psmt.setString(1, vo.getMemberID());
		   psmt.setString(2, vo.getMemberPassword());
		   rs = psmt.executeQuery();
		   if (rs.next()) {
			   vo.setMemberID(rs.getString("member_id"));
			   vo.setMemberName(rs.getString("member_name"));
			   vo.setMemberPassword(rs.getString("member_password"));
			   vo.setMemberTel(rs.getString("member_tel"));
			   vo.setMemberAddress(rs.getString("member_address"));
			   vo.setMemberEmail(rs.getString("member_email"));
		   }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   close();
	   }
	   return vo;
   }

   private void close() {
      // Connection 연결
      try {
         if (rs != null)
            rs.close();
         if (psmt != null)
            psmt.close();
         if (con != null)
            con.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }
   
}