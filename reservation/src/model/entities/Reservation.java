package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn))
			throw new DomainException("check out date must be after check in date");
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	// checkin and checkout days difference
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	// update dates
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now))
			throw new DomainException("reservated dates for updatedmust be future dates");

		if (!checkOut.after(checkIn))
			throw new DomainException("check out date must be after check in date");
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	// print reservation data
	@Override
	public String toString() {
		return "room " + roomNumber + ", check in: " + sdf.format(checkIn)
		+ ", check out: " + sdf.format(checkOut) + ", " + duration() + " nights";
	}
}
