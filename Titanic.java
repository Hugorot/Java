


import java.io.Serializable;

/**
 * Codigo practico, GUI y Ficheros.
 * Universidad Catolica Santiago de Guayaquil.
 * @author PC
 */
public class Titanic implements Serializable {

    double survivor;
    int pclass;
    String Name;
    String Sex;
    int Age;
    int SiblingsSpousesAboard;
    int ParentsChildrenAboard;
    double Fare;

    public Titanic(double survivor, int pclass, String Name, String Sex, int Age, int SiblingsSpousesAboard, int ParentsChildrenAboard, double Fare) {
        this.survivor = survivor;
        this.pclass = pclass;
        this.Name = Name;
        this.Sex = Sex;
        this.Age = Age;
        this.SiblingsSpousesAboard = SiblingsSpousesAboard;
        this.ParentsChildrenAboard = ParentsChildrenAboard;
        this.Fare = Fare;
    }

    public double getSurvivor() {
        return survivor;
    }

    public void setSurvivor(double survivor) {
        this.survivor = survivor;
    }

    public int getPclass() {
        return pclass;
    }

    public void setPclass(int pclass) {
        this.pclass = pclass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getSiblingsSpousesAboard() {
        return SiblingsSpousesAboard;
    }

    public void setSiblingsSpousesAboard(int SiblingsSpousesAboard) {
        this.SiblingsSpousesAboard = SiblingsSpousesAboard;
    }

    public int getParentsChildrenAboard() {
        return ParentsChildrenAboard;
    }

    public void setParentsChildrenAboard(int ParentsChildrenAboard) {
        this.ParentsChildrenAboard = ParentsChildrenAboard;
    }

    public double getFare() {
        return Fare;
    }

    public void setFare(double Fare) {
        this.Fare = Fare;
    }

    @Override
    public String toString() {
        return "Titanic{" + "survivor=" + survivor + ", pclass=" + pclass + ", Name=" + Name + ", Sex=" + Sex + ", Age=" + Age + ", SiblingsSpousesAboard=" + SiblingsSpousesAboard + ", ParentsChildrenAboard=" + ParentsChildrenAboard + ", Fare=" + Fare + '}';
    }
    

}
