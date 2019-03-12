package com.zipcodewilmington.froilansfarm;

import java.util.List;

public class Farmer extends Person implements Botanist, Rider {
    
    private String name;
    private Integer age;
    private Integer id;
    private Silo silo;
    private Stable stable;
    private Barn barn;
    
    public Farmer() {
        name = "Froilan";
        age = 40;
        id = 1;
    }
    
    public Farmer(String name, Integer age, Integer id) {
        super(name, age, id);
    }
    
    public void eat(Edible food) {
        silo.remove(food);
    }
    
    public void mount(Rideable transport) {
        if (transport instanceof Animal) {
            setStable(stable);
            stable.remove((Horse) transport);
        } else if (transport instanceof FarmVehicle) {
            barn.remove((FarmVehicle) transport);
        }
    }

    public void dismount(Rideable transport) {
        if (transport instanceof Animal) {
            stable.store((Horse) transport);
        } else if (transport instanceof FarmVehicle) {
            barn.store((FarmVehicle) transport);
        }
    }
    
    public String makeNoise() {
        return "Hmmm";
    }
    
    public void plant(Crop crop, CropRow rowNumber) {
        rowNumber.store(crop);
    }
    
    public void storeEdible(Edible edible) {
        silo.store(edible);
    }
    
    public void setStable(Stable stable) {
        this.stable = stable;
    }
    
    public void setSilo(Silo silo) {
        this.silo = silo;
    }
    
    public void setBarn(Barn barn) {
        this.barn = barn;
    }

    public static Farmer getFarmer(Farm farm) {
        List<Person> people = Person.getPeople(farm);
        Farmer farmer = null;
        for (Person person : people) {
            if(person instanceof Farmer) {
                farmer = (Farmer) person;
            }
        }
        return farmer;
    }

}
