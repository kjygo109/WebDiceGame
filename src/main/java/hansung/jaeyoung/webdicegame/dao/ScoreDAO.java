package hansung.jaeyoung.webdicegame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import hansung.jaeyoung.webdicegame.dto.Scores;

@Repository
public class ScoreDAO {
	Connection connection;
	
	public ScoreDAO() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dicegame", "root", "csedbadmin");
	}
	public void insertScore(Scores score) throws SQLException {

		PreparedStatement ps = connection.prepareStatement("insert into score(username,win,lose,draw) value(?,?,?,?)");

		ps.setString(1, score.getName());
		ps.setInt(2, score.getWin());
		ps.setInt(3, score.getLose());
		ps.setInt(4, score.getDraw());

		ps.executeUpdate();

		ps.close();
	}
	public List<Scores> selectAllScores() throws Exception {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from score");

			ArrayList<Scores> scores = new ArrayList<Scores>();

			while (rs.next()) {
				scores.add(new Scores().setName(rs.getString("username")).setWin(rs.getInt("win"))
						.setLose(rs.getInt("lose")).setDraw(rs.getInt("draw")));
			}

			return scores;

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
		}
	}
	public Scores selectOne(String username) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from score where username=" + "'" + username + "'");
			if (rs.next()) {
				return new Scores().setName(rs.getString("username")).setWin(rs.getInt("win"))
						.setLose(rs.getInt("lose")).setDraw(rs.getInt("draw"));

			} else {
				return null;
			}

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
		}
	}
	public int update(Scores score) throws Exception {
		PreparedStatement stmt = null;
		String username = score.getName();
		try {
			stmt = connection.prepareStatement(
					"update score set username=?,win=?,lose=?,draw=? where username=" + "'" + username + "'");
			stmt.setString(1, score.getName());
			stmt.setInt(2, score.getWin());
			stmt.setInt(3, score.getLose());
			stmt.setInt(4, score.getDraw());

			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
