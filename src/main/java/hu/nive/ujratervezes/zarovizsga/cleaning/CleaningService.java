package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {

        int totalPrice = 0;
        for (Cleanable cleanable : cleanables) {
            totalPrice += cleanable.clean();
        }

        cleanables.clear();

        return totalPrice;
    }

    public int cleanOnlyOffices() {

        int totalPrice = 0;
        List<Cleanable> toRemove = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable instanceof Office) {
                totalPrice += cleanable.clean();
                toRemove.add(cleanable);
            }

        }
        cleanables.removeAll(toRemove);
        return totalPrice;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable.getAddress().contains(address)) {
                result.add(cleanable);
            }
        }
        return result;
    }


    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable cleanable : cleanables) {
            sb.append(cleanable.getAddress() + ", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }
}


