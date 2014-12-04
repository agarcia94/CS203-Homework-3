package hw3;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        final String roadFilename = args[0];
        final String imageFilename = args[1];
        final String reportFilename = args[2];
        final double x1= Double.parseDouble(args[3]);
        final double y1= Double.parseDouble(args[4]);
        final double x2=Double.parseDouble(args[5]);
        final double y2=Double.parseDouble(args[6]);
      

        final boolean isOSM = true;
      
        RoadNetwork roadNetwork;
		try {
			File file = new File(roadFilename);
			roadNetwork = new RoadNetwork(file, isOSM);
			
	        Point startPoint= roadNetwork.findNearestPoint(x1, y1);  //find the nearest point to the point defined by x1,y1
			Point endPoint= roadNetwork.findNearestPoint(x2, y2); // find the nearest point to the points defined by x2,y2
			roadNetwork.bfs(startPoint, endPoint);  //try to find the route from start to end, using breadth-first search
			roadNetwork.draw();
			
			if(roadNetwork.isp2found() == true){
				ArrayList<Point> pointsTraversed= new ArrayList<Point>();
				StdDraw.setPenColor(Color.GREEN);
				StdDraw.setPenRadius(0.01);
				for(Segment segment : roadNetwork.edges){
					segment.draw();
					pointsTraversed.add(segment.p1);
					pointsTraversed.add(segment.p2);
				}
				
				StdDraw.setPenColor(Color.RED);
				StdDraw.setPenRadius(0.05);
				startPoint.draw();

				StdDraw.setPenColor(Color.BLUE);
				StdDraw.setPenRadius(0.05);
				endPoint.draw();
				
				try {
					File file2 = new File(reportFilename);
					Report re = new Report(file2,true);
					re.write(startPoint, endPoint,pointsTraversed) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else{
				
				File file2 = new File(reportFilename);
				Report re = new Report(file2,false);
			}
				
				
			
			
			
			
			/*
			
			try {
				File file2 = new File(reportFilename);
				Report re = new Report(file2);
				re.write(mostPoints, bestCellConfiguration, startTime, finishTime);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        StdDraw.save(imageFilename);
			
    }
}
