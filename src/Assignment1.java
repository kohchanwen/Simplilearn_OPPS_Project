
import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment1 {

	public static void printMenu(String[] options) {
		System.out.println("Welcome to LockedMe Application.");
		System.out.println("Developer name: Koh Chan Wen.");
		System.out.println("Developer email: chanwen1@hotmail.com");
		System.out.println("Please select 1 of the 3 options: ");

		for (String option : options) {
			System.out.println(option);
		}
	}

	public static void printQ2Menu(String[] options) {
		for (String option : options) {
			System.out.println(option);
		}
	}

	public static void main(String[] args) {
		String[] options = { "1) Get all files in ascending order", "2) Additional file operations",
				"3) Close the application" };
		Scanner scanner = new Scanner(System.in);
		int option = 1;
		while (option != 3) {
			printMenu(options);
			try {
				option = scanner.nextInt();
				switch (option) {
				case 1:
					option1();
					break;
				case 2:
					option2();
					break;
				case 3:
					System.out.println("Thank you for using LockedMe. Closing Application.");
					System.exit(0);
				}
			} catch (InputMismatchException ex) {
				System.out.println("Please enter correct option");
			} catch (Exception ex) {
				System.out.println("An unexpected error happened. Please try again");
				scanner.next();
			}
		}

	}

	private static void option1() {
		File file = new File("C:\\Users\\chanw\\Desktop\\PG_FSD_OPPS_Project\\files");
		String[] pathnames;
		pathnames = file.list();
		Arrays.sort(pathnames); // Sort files by ascending order
		for (String pathname : pathnames) {
			System.out.println(pathname);
		}
	}

	private static void option2() {
		String[] options = { "2.1) Add file to directory", "2.2) Delete a specific file",
				"2.3) Search for specific file", "2.4) Return to main context" };
		Scanner scanner = new Scanner(System.in);
		double option;
		printQ2Menu(options);
		try {
			option = scanner.nextDouble();
			if (option == 2.1) {
				option2_1();
			} else if (option == 2.2) {
				option2_2();
			} else if (option == 2.3) {
				option2_3();
			} else if (option == 2.4) {
				option2_4();
			} else {
				System.out.println("Please enter correct option");
				option2();
			}
		} catch (InputMismatchException ex) {
			System.out.println("Please enter correct option");
		} catch (Exception ex) {
			System.out.println("An unexpected error happened. Please try again");
			scanner.next();
		}

	}

	private static void option2_1() {
		System.out.println("Enter file name to be added:");
		Scanner scanner = new Scanner(System.in);
		String filename;
		filename = scanner.nextLine();
		try {
			File file = new File("C:\\Users\\chanw\\Desktop\\PG_FSD_OPPS_Project\\files\\" + filename);

			if (file.createNewFile()) {
				System.out.println("New File is created!");
			} else {
				if (file.exists()) {
					System.out.println("File already exists.");
					System.out.println("File path:" + file.getAbsolutePath());
					System.out.println("File name:  " + file.getName());

				} else {
					System.out.println("File doesnot exists.");
				}

			}
			option2();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void option2_2() {
		System.out.println("Enter file name to be deleted:");
		Scanner scanner = new Scanner(System.in);
		String filename;
		filename = scanner.nextLine();
		try {
			File file = new File("C:\\Users\\chanw\\Desktop\\PG_FSD_OPPS_Project\\files\\" + filename);

			boolean b = file.delete();
			if (b == true) {
				System.out.println("File deleted !!");
			} else {
				System.out.println("File not deleted");
			}
			option2();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void option2_3() {
		System.out.println("Enter file name to be searched:");
		Scanner scanner = new Scanner(System.in);
		String filename;
		filename = scanner.nextLine();
		try {
			File file = new File("C:\\Users\\chanw\\Desktop\\PG_FSD_OPPS_Project\\files\\" + filename);

			if (file.exists()) {
				System.out.println("File exists in main directory.");
				System.out.println("File path:" + file.getAbsolutePath());
				System.out.println("File name:  " + file.getName());
				System.out.println("File class:  " + file.getClass());
				System.out.println("File space allocated:  " + file.getUsableSpace());
				System.out.println("File length: " + file.length());

			} else {
				System.out.println("File does not exists.");
			}
			option2();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void option2_4() {
		Scanner scanner = new Scanner(System.in);
		boolean choice = true;

		while (choice) {
			System.out.println("Do you wish to go back to main menu? Y/N");
			choice = scanner.nextLine().equalsIgnoreCase("Y") ? true : false;

			if (choice) {
				System.out.println(choice);
				Assignment1.main(new String[0]);
				break;
			} else {
				option2();
				break;
			}
		}

	}

}
