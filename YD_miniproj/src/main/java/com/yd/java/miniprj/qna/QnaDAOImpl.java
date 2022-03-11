package com.yd.java.miniprj.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yd.java.miniprj.common.DAO;

public class QnaDAOImpl implements QnaDAO {
	private Connection con = DAO.getInstance();
	private PreparedStatement psmt;
	private ResultSet rs;
	   
	@Override
	public List<QnaVO> qnaSelectAll() {
		// 전제초회
		List<QnaVO> qna = new ArrayList<QnaVO>();
		QnaVO vo;
		String sql = "SELECT * FROM QNA ORDER BY QNA_ID";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new QnaVO();
				vo.setQnaId(rs.getInt("qna_id"));
				vo.setQnaTitle(rs.getString("qna_title"));
				vo.setQnaContent(rs.getString("qna_content"));
				vo.setQnaDate(rs.getDate("qna_date"));
				vo.setMemberID(rs.getString("member_id"));
				vo.setIsAnswered(rs.getInt("is_answered"));
				vo.setAnswerContent(rs.getString("answer_content"));
				
				qna.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return qna;
	}

	@Override
	public QnaVO qnaSelectOne(QnaVO qna) {
		// 단건조회
		String sql = "SELECT * FROM QNA WHERE QNA_ID = ?";
		QnaVO vo = new QnaVO();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, qna.getQnaId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setQnaId(rs.getInt("qna_id"));
				vo.setQnaTitle(rs.getString("qna_title"));
				vo.setQnaContent(rs.getString("qna_content"));
				vo.setQnaDate(rs.getDate("qna_date"));
				vo.setMemberID(rs.getString("member_id"));
				vo.setIsAnswered(rs.getInt("is_answered"));
				vo.setAnswerContent(rs.getString("answer_content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int qnaInsert(QnaVO qna) {
		// 등록
		String sql = "INSERT INTO QNA(QNA_ID, QNA_TITLE, QNA_CONTENT, QNA_DATE, MEMBER_ID) VALUES(sq_qna.nextval,?,?,sysdate,?)";
		int n = 0;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, qna.getQnaTitle());
			psmt.setString(2, qna.getQnaContent());
			psmt.setString(3, qna.getMemberID());
			
			n= psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	@Override
	public int qnaAnswer(QnaVO qna) {
		String sql = "UPDATE QNA SET ANSWER_CONTENT = ?, IS_ANSWERED = 1 WHERE QNA_ID = ?";
		int n = 0;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, qna.getAnswerContent());
			psmt.setInt(2, qna.getQnaId());
			
			n= psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	private void close() {
        // Connection 연결을 종료
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
