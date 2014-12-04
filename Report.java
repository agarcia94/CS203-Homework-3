package hw3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Report {

	File file; 


	public Report(File file, boolean p2) throws IOException {
		// TODO Auto-generated constructor stub
		this.file=file;

		if(!file.exists()){
			file.createNewFile();
		}

		if(p2 == false)
			write();
	}

	public void add(String message) {
		// TODO Auto-generated method stub

	}

	public void write(){

		FileWriter fw;
		try {
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("P2 not found");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void write(Point start, Point end, ArrayList<Point> points) throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);


		bw.write("start " + start.toString() + '\n');
		bw.write("end " + end.toString() + '\n');
		for(Point p : points)
			bw.write(p.toString() + '\n');

		bw.flush();
		bw.close();

	}
}
