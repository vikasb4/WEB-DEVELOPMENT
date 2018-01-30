package com.saf.emart.pos.service;

import java.util.ArrayList;

public class data {

	String Number ="";
	public String sequenceNumber = "0x00000000", ackNumber = "0x00000000",
			dataOffset = "0x5", reserved = "0x00", flags = "0x000",
			window = "0x0000", checkSum = "0x0000", urgent = "0x0000",
			options = "0x00", padding = "0x0000", data = "0x000000000";

	public String getDataOffset() {
		return dataOffset;
	}

	public void setDataOffset(String dataOffset) {
		this.dataOffset = dataOffset;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getAckNumber() {
		return ackNumber;
	}

	public void setAckNumber(String ackNumber) {
		this.ackNumber = ackNumber;
	}

	public String printNumber() {
		sn serialNumberObject = new sn();

		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add(0, "0x");

		String serialnumber = serialNumberObject.getSerialNumber();
		if (serialnumber.length() != 7) {
			System.out.println("Please Enter a valid Serial Number");
		} else {
			String sourcePortString = serialnumber.substring(3, 7);

			String destinationPortString = serialnumber.substring(0, 4);

			int sourcePortInt = Integer.parseInt(sourcePortString);

			int destinationPortInt = Integer.parseInt(destinationPortString);

			String sourcePort = Integer.toHexString(sourcePortInt);

			String destinationPort = Integer.toHexString(destinationPortInt);

			stringList.add(sourcePort);  
			stringList.add(destinationPort);
			stringList.add(getSequenceNumber().substring(2)); // sequence number
			stringList.add(getAckNumber().substring(2));//acknowledgement number
			stringList.add(getDataOffset().substring(2)); //getting the data offset 
			stringList.add("0000000"); // considering all the other flags are zeros for initial packet

		}

		for (int i = 0; i < stringList.size(); i++) {

			Number = Number + stringList.get(i);
		}

		return Number;
	}

	public static void main(String args[]) {
		data p = new data();

		System.out.println(p.printNumber());

	}
}
