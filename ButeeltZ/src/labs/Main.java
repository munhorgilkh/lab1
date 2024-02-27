package labs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Train 
{
    private String trainNumber;
    private String ownerName;
    private String trainDirection; 

    
    public Train(String trainNumber, String ownerName, String trainDirection) 
    {
        this.trainNumber = trainNumber;
        this.ownerName = ownerName;
        this.trainDirection = trainDirection; 
    }
    
    public String gettrainNumber() 
    {
        return trainNumber;
    }
    
    public String getOwnerName() 
    {
        return ownerName;
    }

    public String gettrainDirection() 
    {
        return trainDirection;
    }

    @Override
    public String toString() 
    {
        return "(" +
                "Галт тэргийн дугаар='" + trainNumber + '\'' +
                ", Зорчигчийн нэр='" + ownerName + '\'' +
                ", Зорчих чиглэл='" + trainDirection + '\'' +
                ')';
    }

}

class ParkingLot<T, U> 
{
    private List<T> parkedTrains;
    private List<U> parkingTickets;

    public ParkingLot() 
    {
        this.parkedTrains = new ArrayList<>();
        this.parkingTickets = new ArrayList<>();
    }

    public void parkTrain(T Train, U ticket) 
    {
        parkedTrains.add(Train);
        parkingTickets.add(ticket);
    }

    public void removeTrain(U ticket) 
    {
        int index = parkingTickets.indexOf(ticket);
        if (index != -1) {
            parkedTrains.remove(index);
            parkingTickets.remove(index);
            System.out.println("Тасалбар цуцлагдлаа.");
        } else {
            System.out.println("Тасалбар илэрсэнгүй. Та дахин оролдоно уу");
        }
    }

    public void displayParkedTrains() 
    {
        System.out.println("Нийт тасалбарын жагсаалт");
        for (T Train : parkedTrains) 
        {
            System.out.println(Train);
        }
    }

    public int getNumberOfParkedTrains() 
    {
        return parkedTrains.size();
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        ParkingLot<Train, String> parkingLot = new ParkingLot<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) 
        {
            System.out.println("\nҮйлчилгээний цэс:");
            System.out.println("1. Тасалбар авах");
            System.out.println("2. Тасалбар цуцлах");
            System.out.println("3. Нийт тасалбар харуулах");
            System.out.println("4. Тасалбар нэмэх");
            System.out.println("5. Дуусгах");
            System.out.print("Сонголтоо оруулна уу ");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("Зорчих чиглэлийн мэдээлэл оруулна уу (Зорчих чиглэл, Эзэмшигчийн нэр):");
                    String regNumber = scanner.next();
                    String ownerName = scanner.next();
                    String trainDirection = "" + (parkingLot.getNumberOfParkedTrains() + 1);
                    Train Train = new Train(regNumber, ownerName, trainDirection);
                    parkingLot.parkTrain(Train, trainDirection);
                    System.out.println( trainDirection+"");
                    break;
                case 2:
                    System.out.println("Цуцлах тасалбарын дугаарыг оруулна уу:");
                    String ticketToRemove = scanner.next();
                    parkingLot.removeTrain(ticketToRemove);
                    break;
                case 3:
                    parkingLot.displayParkedTrains();
                    break;
                case 4:
                    System.out.println("Хэдэн тасалбар нэмэх вэ:");
                    int additionalSpaces = scanner.nextInt();
                    for (int i = 0; i < additionalSpaces; i++) 
                    {
                        String additionaltrainDirection = "Нэмэлт тасалбар" + (parkingLot.getNumberOfParkedTrains() + 1);
                        parkingLot.parkTrain(null, additionaltrainDirection);
                    }
                    System.out.println("Тасалбар нэмэгдлээ");
                    break;
                case 5:
                    exit = true;
                    System.out.println("...................");
                    break;
                default:
                    System.out.println("Зөв утга оруулна уу!.");
            }
        }

        scanner.close();
        
    }
}
