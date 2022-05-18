package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reservation.model.Reservation;

public class AdmindDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Reservation reservation = null;
	public ArrayList<Reservation> getAllReservationInfo(Connection conn, ArrayList<Reservation> reservations) throws SQLException {
		pstmt = conn.prepareStatement("select * from reservation");
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reservation = new Reservation(rs.getInt(1), rs.getString(2),
						rs.getString(3));
				reservations.add(reservation);
			}
		} catch (Exception e) {
			System.out.println("error : AdmindDAO.getAllReservationInfo()");
		}
		return reservations;
	}
}
