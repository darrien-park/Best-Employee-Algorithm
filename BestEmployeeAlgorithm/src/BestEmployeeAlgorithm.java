import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BestEmployeeAlgorithm {

	public static void main(String[] args) {
	    //START MAIN
		//Create empty buffers of array lists to store the CSV file values dynamically as doubles
		ArrayList<Double> es1 = new ArrayList<Double>();
		ArrayList<Double> es2 = new ArrayList<Double>();
		ArrayList<Double> es3 = new ArrayList<Double>();
		ArrayList<Double> us1 = new ArrayList<Double>();
		ArrayList<Double> us2 = new ArrayList<Double>();
		ArrayList<Double> us3 = new ArrayList<Double>();
		ArrayList<Double> us4 = new ArrayList<Double>();
		
		//import data
		//es1.csv
		String csvFile1 = "/Users/darrienpark/eclipse-workspace/CMPE365Lab1/src/es1.csv";
		try {
			importCSV(csvFile1, es1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//es2.csv
		String csvFile2 = "/Users/darrienpark/eclipse-workspace/CMPE365Lab1/src/es2.csv";
		try {
			importCSV(csvFile2, es2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//es3.csv
		String csvFile3 = "/Users/darrienpark/eclipse-workspace/CMPE365Lab1/src/es3.csv";
		try {
			importCSV(csvFile3, es3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//us1.csv
		String csvFile4 = "/Users/darrienpark/eclipse-workspace/CMPE365Lab1/src/us1.csv";
		try {
			importCSV(csvFile4, us1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//us2.csv
		String csvFile5 = "/Users/darrienpark/eclipse-workspace/CMPE365Lab1/src/us2.csv";
		try {
			importCSV(csvFile5, us2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//us3.csv
		String csvFile6 = "/Users/darrienpark/eclipse-workspace/CMPE365Lab1/src/us3.csv";
		try {
			importCSV(csvFile6, us3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//us4.csv
		String csvFile7 = "/Users/darrienpark/eclipse-workspace/CMPE365Lab1/src/us4.csv";
		try {
			importCSV(csvFile7, us4);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//es1
		Double bestScore1 = bestScore(es1);
		System.out.println("After examining every employee," + '\n' + "The best score of es1.csv is: " + bestScore1);
		//es2
		Double bestScore2 = bestScore(es2);
		System.out.println("The best score of es2.csv is: " + bestScore2);
		//es3
		Double bestScore3 = bestScore(es3);
		System.out.println("The best score of es3.csv is: " + bestScore3);
		//us1
		Double bestScore4 = bestScore(us1);
		System.out.println("The best score of us1.csv is: " + bestScore4);
		//us2
		Double bestScore5 = bestScore(us2);
		System.out.println("The best score of us2.csv is: " + bestScore5);
		//us3
		Double bestScore6 = bestScore(us3);
		System.out.println("The best score of us3.csv is: " + bestScore6);
		//us4
		Double bestScore7 = bestScore(us4);
		System.out.println("The best score of us4.csv is: " + bestScore7);
		
		//examine the first n/e employees and then pick the first best score after
		System.out.println('\n'+"After applying the improved algorithm," + '\n' + "The best score of es1.csv is: " + improvedBestScore(es1));
		System.out.println("The best score of es2.csv is: " + improvedBestScore(es2));
		System.out.println("The best score of es3.csv is: " + improvedBestScore(es3));
		System.out.println("The best score of us1.csv is: " + improvedBestScore(us1));
		System.out.println("The best score of us2.csv is: " + improvedBestScore(us2));
		System.out.println("The best score of us3.csv is: " + improvedBestScore(us3));
		System.out.println("The best score of us4.csv is: " + improvedBestScore(us4));
		
	//END MAIN
	}
		
	//FUNCTIONS
	public static void importCSV(String filename, ArrayList<Double> list) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
	    scanner.useDelimiter(",");
	    while(scanner.hasNext()){
	    	Double temp = Double.parseDouble(scanner.next());
	    	list.add(temp);
	    }
	scanner.close();
	return;
	}
	
	public static double bestScore(ArrayList<Double> list){
		double bestScore = 0;
		int n = list.size();
		for(int i=0; i<n; i++){
			if (list.get(i) > bestScore){
				bestScore = list.get(i);
			}
			
		}
		return bestScore;
	}
	
	public static double improvedBestScore(ArrayList<Double> list){
		double bestScore = 0;
		int arrayLength = (int) (list.size()/Math.E);
		for (int i = 0; i< arrayLength; i++){
			if (list.get(i) > bestScore){
				bestScore = list.get(i);
			}
		}
		for (int j = arrayLength; j < list.size(); j++){
			if (list.get(j) > bestScore){
				bestScore = list.get(j);
				break;
			}
		}
		return bestScore;
	}
}
