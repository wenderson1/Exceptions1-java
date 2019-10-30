package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
		private int roomNumber;	
		private Date checkIn;
		private Date checkOut;
		
		private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	
		public Reservation(int roomNumber, Date checkIn, Date checkOut) {
				super();
				this.roomNumber = roomNumber;
				this.checkIn = checkIn;
				this.checkOut = checkOut;
			}
		
		
		public int getRoomNumber() {
			return roomNumber;
		}
		
		
		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}
		
		
		public Date getCheckIn() {
			return checkIn;
		}
		
		
		public void setCheckIn(Date checkIn) {
			this.checkIn = checkIn;
		}
		
		
		public Date getCheckOut() {
			return checkOut;
		}
		
		
		public void setCheckOut(Date checkOut) {
			this.checkOut = checkOut;
		}

		public long duration() {
			long diff = checkOut.getTime() - checkIn.getTime();
			return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
		}

		public String updateDate(Date checkIn, Date checkOut) {
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
				return "Error in reservation: Check-out date must br after check-in date";
			}
			
			if(!checkOut.after(checkIn)){
				return "Error in reservation: Check-out date must br after check-in date";	
			}
			
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			return null;
		}
		
		@Override
		public String toString() {
			return "Room"
					+roomNumber
					+", check-in: "
					+ sdf.format(checkIn)
					+", check-out: "
					+sdf.format(checkOut)
					+", "
					+duration()
					+" nights";
		}


}
