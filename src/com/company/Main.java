package com.company;
import java.io.PrintStream;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static class AnyDimensions{
        Integer width;
        Integer height;
        Integer length;
        public AnyDimensions(Integer width, Integer height, Integer length) {
            this.width = width;
            this.height = height;
            this.length = length;
        }
    }

    public static class Transport {
        String model;
        String color;
        Integer power;
        AnyDimensions dimensions;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getPower() {
            return power;
        }

        public void setPower(Integer power) {
            this.power = power;
        }

        public AnyDimensions getDimensions() {
            return dimensions;
        }

        public void setDimensions(Integer width, Integer height, Integer length) {
            this.dimensions = new AnyDimensions(width, height, length);
        }

        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", this.getClass().getName().split("\\$")[1], getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n%n", dimensions.width);
        }
    }


    public static class LandTransport extends Transport
    {
        Integer numberOfDoors;

        public Integer getNumberOfDoors() {
            return numberOfDoors;
        }

        public void setNumberOfDoors(Integer numberOfDoors) {
            this.numberOfDoors = numberOfDoors;
        }

        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Сухопутный транспорт'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Дверей = %d%n%n", getNumberOfDoors());
        }

    }


    public static class SportsCar extends LandTransport
    {
        Float aerodynamicsRating;
        public Float getAerodynamicsRating() {
            return aerodynamicsRating;
        }

        public void setAerodynamicsRating(Float aerodynamicsRating) {
            this.aerodynamicsRating = aerodynamicsRating;
        }

        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Спорткар'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Показатель аэродинамики = %f%n%n", getAerodynamicsRating());
        }
    }

    public static class ElectricSportsCar extends  SportsCar
    {
        Integer batteryVolume;
        public Integer getBatteryVolume() {
            return batteryVolume;
        }

        public void setBatteryVolume(Integer batteryVolume) {
            this.batteryVolume = batteryVolume;
        }
        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Электроспорткар'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Емкость аккумулятора = %d%n%n", getBatteryVolume());
        }
    }


    public static class SeaTransport extends Transport
    {
        Integer liftingCapacity;

        public Integer getLiftingCapacity() {
            return liftingCapacity;
        }

        public void setLiftingCapacity(Integer liftingCapacity) {
            this.liftingCapacity = liftingCapacity;
        }

        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Морской транспорт'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Грузоподъемность = %d%n%n", getLiftingCapacity());
        }
    }


    public static class AirTransport  extends Transport
    {
        Integer liftingCapacity;

        public Integer getLiftingCapacity() {
            return liftingCapacity;
        }

        public void setLiftingCapacity(Integer liftingCapacity) {
            this.liftingCapacity = liftingCapacity;
        }

        @Override
        public void getDescription()
        {
            System.out.printf("Это класс : %s, модель: %s %n", "'Воздушный транспорт'", getModel());
            System.out.printf("Мощность = %d, цвет = %s%n", getPower(), getColor());
            System.out.println("Габариты :");
            System.out.printf("\tДлина  = %d%n", dimensions.length);
            System.out.printf("\tВысота = %d%n", dimensions.height);
            System.out.printf("\tШирина = %d%n", dimensions.width);
            System.out.printf("Грузоподъемность = %d%n%n", getLiftingCapacity());
        }
    }
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        String[] models = {"Toyota", "Mazda", "Honda", "Tesla", "Lada"};
        String[] colors = {"Red", "Purple", "Blue", "Green", "Yellow"};   
        System.out.println("Enter N");
        int N = in.nextInt();
        Transport[] transportArray = new Transport[N];
        for (int i=0; i < N; i++) {
            switch (random.nextInt(5)) {
                case 0 -> {
                    LandTransport land = new LandTransport();
                    land.setNumberOfDoors(random.nextInt(5));
                    transportArray[i] = land;
                }
                case 1 -> {
                    SportsCar sport = new SportsCar();
                    sport.setAerodynamicsRating(random.nextFloat() * 100);
                    transportArray[i] = sport;
                }
                case 2 -> {
                    ElectricSportsCar esport = new ElectricSportsCar();
                    esport.setBatteryVolume(random.nextInt(1000));
                    transportArray[i] = esport;
                }
                case 3 -> {
                    SeaTransport sea = new SeaTransport();
                    sea.setLiftingCapacity(random.nextInt(1000));
                    transportArray[i] = sea;
                }
                case 4 -> {
                    AirTransport air = new AirTransport();
                    air.setLiftingCapacity(random.nextInt(1000));
                    transportArray[i] = air;
                }
            }
            transportArray[i].setModel(models[random.nextInt(5)]);
            transportArray[i].setColor(colors[random.nextInt(5)]);
            transportArray[i].setDimensions(random.nextInt(5), random.nextInt(5), random.nextInt(5));
            transportArray[i].setPower(random.nextInt(3000));
        }
        for (int i = 0; i < N; i++)
        {
            transportArray[i].getDescription();
        }
    }
}
