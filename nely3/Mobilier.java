package nely3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;


public abstract class Mobilier {
    private String producator;
    private float pret;

    public Mobilier() {
    }

    public Mobilier(String producator, float pret) {
        this.producator = producator;
        this.pret = pret;
    }


    @Override
    public int hashCode() {
        return Objects.hash(producator, pret);
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }
}
