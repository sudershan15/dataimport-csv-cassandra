package com.examples.cassandra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CSVParser {
	public static TableModel parse(File f) throws FileNotFoundException {

		ArrayList<String> headers = new ArrayList<String>();
		ArrayList<String> oneDdata = new ArrayList<String>();

		// Get the headers of the table.
		Scanner lineScan = new Scanner(f);
		Scanner s = new Scanner(lineScan.nextLine());
		s.useDelimiter(",");
		while (s.hasNext()) {
			headers.add(s.next());
		}

		// Go through each line of the table and add each cell to the ArrayList
		while (lineScan.hasNextLine()) {
		s = new Scanner(lineScan.nextLine());
		s.useDelimiter(", *");
		while (s.hasNext()) {
			oneDdata.add(s.next());
		}
		}
		String[][] data = new String[headers.size()][oneDdata.size()/headers.size()];

		// Move the data into a vanilla array so it can be put in a table.
		for (int x = 0; x < headers.size(); x++) {
		for (int y = 0; y < data[0].length; y++) {
		data[x][y] = oneDdata.remove(0);
		}
		}

		// Create a table and return it.
		return new DefaultTableModel(data, headers.toArray());

		}

}

